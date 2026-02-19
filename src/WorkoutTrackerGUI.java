import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkoutTrackerGUI extends JFrame implements ActionListener {
        public JTextField textField;
        private JPanel exerciseContainer;
        private static final int PANEL_HEIGHT = 400;
        private static final int PANEL_WIDTH = 400;
        private static final int INPUT_WIDTH = 50;
        private static final int INPUT_HEIGHT = 20;

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
            add(createTopPanel(), BorderLayout.NORTH);
            add(createExerciseContainer(), BorderLayout.CENTER);
    }

    private JScrollPane createExerciseContainer() {
        exerciseContainer = new JPanel();
        exerciseContainer.setLayout(new BoxLayout(exerciseContainer, BoxLayout.Y_AXIS));
        return new JScrollPane(exerciseContainer);
    }
    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel();
        JLabel label = new JLabel("Add Exercise");
        textField = new JTextField(20);
        JButton addButton = new JButton("Add");

        topPanel.add(label);
        topPanel.add(textField);
        topPanel.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        topPanel.add(addButton);
        addButton.addActionListener(this);

        return topPanel;
    }

    private JTextField addTextField(JPanel exercisePanel, String labelText) {
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        exercisePanel.add(new JLabel(labelText));
        exercisePanel.add(field);
        return field;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String exercise = textField.getText();
        if (exercise.isEmpty()){
            System.out.println("Please input an exercise");
        }
        else {
            exerciseContainer.add(createExercisePanel(exercise));
            revalidate();
            repaint();
        }
    }

    private JPanel createExercisePanel(String exercise) {
        JPanel exercisePanel = new JPanel();
        exercisePanel.setPreferredSize(new Dimension(PANEL_WIDTH, 40));
        exercisePanel.setMaximumSize(new Dimension(PANEL_WIDTH, 40));

        exercisePanel.add(new JLabel(exercise));
        JTextField reps   = addTextField(exercisePanel, "Reps: ");
        JTextField sets   = addTextField(exercisePanel, "Sets: ");
        JTextField weight = addTextField(exercisePanel, "Weight: ");

        return exercisePanel;
    }
}
