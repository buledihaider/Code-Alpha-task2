import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCountApp extends JFrame {

    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCountApp() {
        // Set up the frame
        setTitle("Word Count Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create components
        textArea = new JTextArea(10, 30);
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word Count: 0");

        // Set up the panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // Add components to the panel
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(countButton, BorderLayout.SOUTH);
        panel.add(resultLabel, BorderLayout.NORTH);

        // Add panel to the frame
        add(panel);

        // Add action listener to the button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                resultLabel.setText("Word Count: " + wordCount);
            }
        });
    }

    // Method to count words in a given string
    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCountApp().setVisible(true);
            }
        });
    }
}
