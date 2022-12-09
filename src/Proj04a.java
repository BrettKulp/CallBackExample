import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Proj04a extends JFrame {
    private JPanel mainPanel;
    private DialogP04 dialogP04;
    JMenuItem editPrefsItem;

    public Proj04a() {

        super("Project 04");

        ActionHandler ah = new ActionHandler();
        mainPanel = new JPanel();
        add(mainPanel);

        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);

        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        jmb.add(editMenu);

        editPrefsItem = new JMenuItem("Preferences...");
        editPrefsItem.setMnemonic('P');
        editPrefsItem.addActionListener(ah);
        editMenu.add(editPrefsItem);

        mainPanel.setBackground(Color.GREEN);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }

    private class ActionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == editPrefsItem)
            {
                if(dialogP04 == null)

                if(dialogP04 == null)
                    dialogP04 = new DialogP04(Proj04a.this, true);
                dialogP04.setSelectedColor(mainPanel.getBackground());
                dialogP04.setVisible(true);
                if(dialogP04.Okay())
                    mainPanel.setBackground(dialogP04.getColor());
            }

        }
    }
}