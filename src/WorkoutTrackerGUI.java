import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WorkoutTrackerGUI extends JFrame implements ActionListener {
        ArrayList<String> workout = new ArrayList<>();
        public JTextField textField;

    public WorkoutTrackerGUI() {
            super("Workout Tracker");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(450, 650);
            setLayout(new BorderLayout(10,10));
            setLocationRelativeTo(null);
            setResizable(false);
            addGuiComponents();
        }
        private void addGuiComponents() {
            JPanel topPanel = new JPanel();
            textField = new JTextField(20);
            JLabel label = new JLabel("Add Exercise");
            JButton addButton = new JButton("Add");

            topPanel.add(textField);
            topPanel.add(label);
            topPanel.add(addButton);
            topPanel.add(textField);
            topPanel.setSize(400, 400);

            add(topPanel, BorderLayout.NORTH);
            addButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel exercisePanel = new JPanel();
        String exercise = textField.getText();
        System.out.print(exercise);

        JLabel exerciseName = new JLabel(exercise);


        JTextField reps = new JTextField();


        JTextField sets = new JTextField();


        JTextField weight = new JTextField();

        exercisePanel.add(exerciseName);
        exercisePanel.add(reps);
        exercisePanel.add(sets);
        exercisePanel.add(weight);
        exercisePanel.setSize(400, 400);

        add(exercisePanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
}
