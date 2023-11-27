import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Frame extends JFrame {

    Queue<String> queue;
    JList<String> data;


    public static void main() {
        Frame frame = new Frame("Lab10");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
    Frame(String title) {
        super(title);
        setLayout(new BorderLayout());

        queue = new Queue<>();
        initPushFunction();
        initPopFunction();

    }

    private void initPushFunction() {
        data = new JList<>(queue.getListModel());
        JScrollPane dataScrollPane = new JScrollPane(data, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        data.setPreferredSize(new Dimension(300, 200));
        add(dataScrollPane, BorderLayout.CENTER);

        JPanel pushPanel = new JPanel();
        JButton pushButton = new JButton("Push");
        JTextField pushTextField = new JTextField(25);
        pushTextField.setPreferredSize(new Dimension(150, 20));
        pushPanel.add(pushButton, pushTextField);
        pushPanel.add(pushTextField);
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pushData = pushTextField.getText();
                /*StringTokenizer stringTokenizer = new StringTokenizer(pushData, ";");
                while (stringTokenizer.hasMoreTokens()) {
                    queue.push(stringTokenizer.nextToken());
                }*/
                queue.pushAll(List.of(pushData.split(";")));
                data.setModel(queue.getListModel());
                pushTextField.setText("");
            }
        });

        add(pushPanel, BorderLayout.NORTH);

    }

    private void initPopFunction() {
        JButton popButton = new JButton("Pop");
        add(popButton, BorderLayout.SOUTH);
        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    queue.pop();
                    data.setModel(queue.getListModel());
                } catch (NoSuchElementException ex) {
                    JOptionPane.showMessageDialog(null, "There are no elements in list");
                }
            }
        });
    }


}
