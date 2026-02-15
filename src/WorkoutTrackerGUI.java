import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkoutTrackerGUI extends JFrame implements ActionListener {
        public JTextField textField;
        private JPanel exerciseContainer;

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
            exerciseContainer = new JPanel();
            exerciseContainer.setLayout(new BoxLayout(exerciseContainer, BoxLayout.Y_AXIS));
            JScrollPane scrollPane = new JScrollPane(exerciseContainer);
            textField = new JTextField(20);
            JLabel label = new JLabel("Add Exercise");
            JButton addButton = new JButton("Add");

            topPanel.add(textField);
            topPanel.add(label);
            topPanel.add(addButton);
            topPanel.add(textField);
            topPanel.setSize(400, 400);

            add(topPanel, BorderLayout.NORTH);
            add(scrollPane, BorderLayout.CENTER);
            addButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel exercisePanel = new JPanel();
        String exercise = textField.getText();
        System.out.print(exercise);
        JLabel exerciseName = new JLabel(exercise);
        JLabel repsText = new JLabel("Reps: ");
        JLabel setsText = new JLabel("Sets: ");
        JLabel weightText = new JLabel("Weight: ");



        JTextField reps = new JTextField();
        reps.setPreferredSize(new Dimension(50, 20));

        JTextField sets = new JTextField();
        sets.setPreferredSize(new Dimension(50, 20));

        JTextField weight = new JTextField();
        weight.setPreferredSize(new Dimension(50, 20));



        exercisePanel.add(exerciseName);
        exercisePanel.add(repsText);
        exercisePanel.add(reps);
        exercisePanel.add(setsText);
        exercisePanel.add(sets);
        exercisePanel.add(weightText);
        exercisePanel.add(weight);
        exercisePanel.setSize(400, 400);
        exerciseContainer.add(exercisePanel);


        revalidate();
        repaint();

    }
}
