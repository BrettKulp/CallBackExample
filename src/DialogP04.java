import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogP04 extends JDialog
{
    private JRadioButton[] colorRB;
    private Color color;
    private JFrame parent;
    private boolean isOkay;
    private JButton okayButton, cancelButton;
    public DialogP04(JFrame parent, boolean modal)
    {
        super(parent, modal);

        JPanel diaglogPanel = new JPanel();
        GridLayout layout = new GridLayout(2,1);
        layout.setHgap(10);
        diaglogPanel.setLayout(layout);
        ButtonGroup buttonGroup = new ButtonGroup();
        ActionHandler ah = new ActionHandler();

        JPanel colorPanel = new JPanel();
        String[] rbCaps = {"Red", "Green", "Blue", "dummy"};
        colorRB = new JRadioButton[rbCaps.length];
        buttonGroup =  new ButtonGroup();
        for(int i=0;i< rbCaps.length;i++)
        {
            colorRB[i] = new JRadioButton(rbCaps[i]);
            buttonGroup.add(colorRB[i]);
            if(i < rbCaps.length - 1)
            colorPanel.add(colorRB[i]);
        }
        diaglogPanel.add(colorPanel);

        JPanel buttonPanel = new JPanel();
        okayButton = new JButton("Okay");
        okayButton.addActionListener(ah);
        buttonPanel.add(okayButton);
        cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);
        cancelButton.addActionListener(ah);
        diaglogPanel.add(buttonPanel);

        add(diaglogPanel);
        setSize(300, 150);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public Color getColor()
    {

        if(colorRB[0].isSelected())
            return(Color.RED);
        else if(colorRB[1].isSelected())
            return(Color.GREEN);
        else if(colorRB[2].isSelected())
            return(Color.BLUE);
        else
            return(null);
    }

    public void setSelectedColor(Color color)
    {
        if(color == color.RED)
            colorRB[0].setSelected(true);
        else if(color == color.GREEN)
            colorRB[1].setSelected(true);
        else if(color == color.BLUE)
            colorRB[2].setSelected(true);//*/
    }

    public boolean Okay()
    {
        return isOkay;
    }

    private class ActionHandler implements ActionListener
    {
    public void actionPerformed(ActionEvent e)
        {
           if(e.getSource() == okayButton) {
               isOkay = true;
               setVisible(false);
           }
           if(e.getSource() == cancelButton) {
               isOkay = false;
               setVisible(false);
           }
        }
    }
}
