package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchFrame extends JFrame {

    private JPanel bannerPanel;
    private JLabel bannerLabel;

    private JPanel buttonsPanel;
    private JPanel newGameButtonPanel;
    private JPanel loadGameButtonPanel;
    private JButton newGameButton;
    private JButton loadGameButton;
    boolean AIMode;

    public LaunchFrame() {
        super("Chess");
        loadInterface();
    }

    private void loadInterface() {
        initializeBannerPanel();
        initializeButtonsPanel();

        this.setLayout(new BorderLayout());
        this.add(bannerPanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    private void initializeBannerPanel() {
        bannerLabel = new JLabel();
        bannerLabel.setIcon(new ImageIcon(getClass().getResource("/Resources/images/chess_baner.png")));
        bannerPanel = new JPanel();
        bannerPanel.add(bannerLabel);
        bannerPanel.setPreferredSize(new Dimension(600, 250));
        bannerPanel.setBackground(Color.LIGHT_GRAY);
    }

    private void initializeButtonsPanel() {
        newGameButton = new JButton("vs Human");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AIMode = false;
                new Humanpanel();
                setVisible(false);
            }
        });
        newGameButtonPanel = new JPanel(new GridLayout(1, 1));
        newGameButtonPanel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 25));
        newGameButtonPanel.add(newGameButton);

        newGameButtonPanel.add(newGameButton);
        
        loadGameButton = new JButton("vs AI");
        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AIMode = true;
                new AIpanel();
                setVisible(false);
            }
        });
        
        loadGameButtonPanel = new JPanel(new GridLayout(1, 1));
        loadGameButtonPanel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 30));
        loadGameButtonPanel.add(loadGameButton);


        buttonsPanel = new JPanel(new GridLayout(1, 2));
        buttonsPanel.setPreferredSize(new Dimension(600, 150));
        buttonsPanel.add(newGameButtonPanel);
        buttonsPanel.add(loadGameButtonPanel);
    }

}
