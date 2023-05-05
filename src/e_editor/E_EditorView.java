package e_editor;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class E_EditorView extends JFrame {
    private UndoManager deshacer;
    private JTextArea textArea;
    private JToolBar toolBar;
    private JButton buttonOpen;
    private JButton buttonSave;
    private JLabel statusBar;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem menuItemClose;
    private JMenu menuEdit;
    private JMenuItem menuItemUndo;
    private JMenu menuHelp;
    private JMenuItem menuItemAbout;
    private JPopupMenu popupMenu;
    private JMenuItem menuItemCopy;
    private JMenuItem menuItemPaste;
    private Clipboard clipboard;

    public E_EditorView() {
        initComponents();
        addListeners();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
    }

    private void initComponents() {
        deshacer = new UndoManager();
        deshacer.setLimit(10);
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        textArea = new JTextArea();
        toolBar = new JToolBar();
        buttonOpen = new JButton("Open");
        buttonSave = new JButton("Save");
        statusBar = new JLabel("lines: 0");
        statusBar.setHorizontalAlignment(SwingConstants.RIGHT);
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuItemClose = new JMenuItem("Close");
        menuEdit = new JMenu("Edit");
        menuItemUndo = new JMenuItem("Undo");
        menuHelp = new JMenu("Help");
        menuItemAbout = new JMenuItem("About");
        popupMenu = new JPopupMenu();
        menuItemCopy = new JMenuItem("Copy");
        menuItemPaste = new JMenuItem("Paste");

        menuBar.add(menuFile);
        menuFile.add(menuItemClose);
        menuBar.add(menuEdit);
        menuEdit.add(menuItemUndo);
        menuBar.add(menuHelp);
        menuHelp.add(menuItemAbout);
        this.setJMenuBar(menuBar);

        popupMenu.add(menuItemCopy);
        popupMenu.add(menuItemPaste);

        toolBar.add(buttonOpen);
        toolBar.add(buttonSave);

        this.setLayout(new BorderLayout());
        this.add(toolBar,BorderLayout.NORTH);
        this.add(textArea,BorderLayout.CENTER);
        this.add(statusBar, BorderLayout.SOUTH);

        this.pack();
    }

    private void addListeners() {
        menuItemAbout.addActionListener(e -> showAboutDialog());
        menuItemClose.addActionListener(e -> System.exit(0));
        buttonOpen.addActionListener(e -> openFile());
        buttonSave.addActionListener(e -> saveFile());
        textArea.getDocument().addUndoableEditListener(e -> deshacer.addEdit(e.getEdit()));
        menuItemUndo.addActionListener(e -> deshacer.undo());
        textArea.addCaretListener(e -> updateStatusBar());
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPopupMenu(e);
            }
        });
        menuItemCopy.addActionListener(e -> copyText());
        menuItemPaste.addActionListener(e -> pasteText());
    }

    private void copyText() {
        if (textArea.getSelectedText()!= null){
            StringSelection seleccion = new StringSelection(""+textArea.getSelectedText());
            clipboard.setContents(seleccion, seleccion);
        }
    }

    private void pasteText() {
        Transferable datos = clipboard.getContents(null);
        try {
            if (datos != null && datos.isDataFlavorSupported(DataFlavor.stringFlavor))
                textArea.replaceSelection(""+datos.getTransferData(DataFlavor.stringFlavor));
        } catch (UnsupportedFlavorException | IOException ex) {System.err.println(ex);}
    }

    private void showPopupMenu(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3) {
            popupMenu.setVisible(true);
            popupMenu.show(this,e.getX(), e.getY());
        } else {
            popupMenu.setVisible(false);
        }
    }

    private void updateStatusBar() {
        statusBar.setText("lines: "+textArea.getLineCount());
    }

    private void openFile() {
        var fileChooser = new JFileChooser();

        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (Scanner scanner = new Scanner(fileChooser.getSelectedFile())) {
                while (scanner.hasNext()) {
                    textArea.setText(textArea.getText() + '\n' + scanner.nextLine());
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveFile() {
        JFileChooser selector=new JFileChooser();
        int opcion = selector.showSaveDialog(this);
        File archivo = selector.getSelectedFile();
        try (FileWriter escritor = new FileWriter(archivo)) {
            if (opcion == JFileChooser.APPROVE_OPTION)
                if(archivo !=null)
                    escritor.write(textArea.getText());
        } catch(IOException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }

    private void showAboutDialog() {
        JOptionPane.showMessageDialog(
                this,
                "Ejemplo de bloc denotas hecho en Java Swing",
                "About Swing Notepad",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
