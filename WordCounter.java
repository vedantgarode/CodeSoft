import java.util.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WordCounter {
    public int CountWord(String a) {
        return 0;
    }

    public WordCounter() {
        JFrame frame = new JFrame("Word Counter");

        JLabel l1 = new JLabel("Total Words :");
        l1.setBounds(100, 230, 300, 50);

        JLabel l2 = new JLabel("Unique Words :");
        l2.setBounds(100, 250, 300, 50);

        JLabel l3 = new JLabel("Frequency :");
        l3.setBounds(100, 270, 300, 50);

        JTextArea t1 = new JTextArea();
        t1.setBounds(50, 20, 400, 150);
        t1.setLineWrap(true); // Enable line wrapping
        t1.setWrapStyleWord(true); // Wrap at word boundaries

        JScrollPane scrollPane = new JScrollPane(t1);
        scrollPane.setBounds(50, 20, 400, 150);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton b1 = new JButton("Calculate");
        b1.setBounds(200, 200, 100, 30);

        frame.add(scrollPane); // Add the JScrollPane to the frame
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the helper function when the button is clicked
                String[] wordsArray = t1.getText().split("\\s+");
                HashMap<String, Integer> map = new HashMap<>();
                for (String word : wordsArray) {
                    if (map.containsKey(word)) {
                        int count = map.get(word);
                        map.put(word, ++count);
                    } else {
                        map.put(word, 1);
                    }
                }
                l1.setText( "Total Words : " + wordsArray.length);
                l2.setText( "Unique Words : " + map.size());
                Iterator iter = map.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry mapElement = (Map.Entry) iter.next();
                    int count = ((int) mapElement.getValue());
                    // Printing mark corresponding to string entries
                    l3.setText(l3.getText()  + mapElement.getKey() + " :" + count + " | " );
                }
            }
        });
        frame.add(b1);
        frame.add(l1);
        frame.add(l2);

        

        JScrollPane labelScrollPane = new JScrollPane(l3);
        labelScrollPane.setBounds(100, 300, 300, 50);
        labelScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(labelScrollPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        WordCounter w1 = new WordCounter();
    }
}
