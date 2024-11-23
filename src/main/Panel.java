package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kalud
 * @website pixelskider.github.io/
 * @since 2024/11/22
 */
public class Panel extends JPanel implements ActionListener{
    JLabel textLabel;
    JButton putButton,aboutButton;
    JCheckBox iconBox,taskbarBox;
    Config config = new Config();

    public Panel(int width,int height){
        config.readConfig();
        this.setSize(width,height);
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        textLabel = new JLabel();
        textLabel.setLocation(3,3);
        textLabel.setSize(100,20);

        putButton = new JButton();
        putButton.setLocation(80,3);
        putButton.setSize(70,30);
        putButton.addActionListener(this);

        aboutButton = new JButton("About");
        aboutButton.setLocation(80,36);
        aboutButton.setSize(70,30);
        aboutButton.addActionListener(this);

        iconBox = new JCheckBox("Icon");
        iconBox.setSize(72,20);
        iconBox.setLocation(3,25);

        taskbarBox = new JCheckBox("Taskbar");
        taskbarBox.setSize(72,20);
        taskbarBox.setLocation(3,45);

        update();
        this.add(textLabel);
        this.add(putButton);
        this.add(aboutButton);
        this.add(iconBox);
        this.add(taskbarBox);

    }

    private void update(){
        textLabel.setText(config.stateBoolean ? "State: True" : "State: False");
        putButton.setText(config.stateBoolean ? "Close" : "Open");
        iconBox.setSelected(config.iconBoolean);
        taskbarBox.setSelected(config.taskBarBoolean);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Regedit regedit = new Regedit();
        if (e.getSource() == putButton){
            config.iconBoolean = iconBox.isSelected();
            config.taskBarBoolean = taskbarBox.isSelected();
            config.stateBoolean = !config.stateBoolean;
            config.saveConfig();
            update();

            if (config.stateBoolean){
                regedit.changeIcon(config.iconBoolean);
                regedit.changeTaskBar(config.taskBarBoolean);
                regedit.refreshExplorer();
            }else {
                regedit.changeIcon(false);
                regedit.changeTaskBar(false);
                regedit.refreshExplorer();
            }
        }else{
            JOptionPane.showMessageDialog(null, "DesktopManager By PixelSkider\nBlog: pixelskider.github.io\nPlease use Admin Run\nIt is normal to have stuttering when using", "About && Information",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
