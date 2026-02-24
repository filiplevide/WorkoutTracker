import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WorkoutTrackerGUI extends JFrame implements ActionListener {
        public JTextField textField;
        private ArrayList<ArrayList<JTextField>> exerciseList = new ArrayList<>();
        private JPanel exerciseContainer;
        private static final int PANEL_HEIGHT = 400;
        private static final int PANEL_WIDTH = 400;
        private static final int INPUT_WIDTH = 50;
        private static final int INPUT_HEIGHT = 20;
        private JButton addButton;
        private JButton calculationButton;

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
            add(createCalculationPanel(), BorderLayout.SOUTH);
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
        addButton = new JButton("Add");

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

        if (e.getSource() == addButton) {
            String exercise = textField.getText();
            if (exercise.isEmpty()) {
                System.out.println("Please input an exercise");
            } else {
                exerciseContainer.add(createExercisePanel(exercise));
                revalidate();
                repaint();
            }
        }
        else if (e.getSource() == calculationButton) {
            calculateTotalWeight();
        }
    }


    private JPanel createExercisePanel(String exercise) {
        JPanel exercisePanel = new JPanel();
        exercisePanel.setPreferredSize(new Dimension(PANEL_WIDTH, 40));
        exercisePanel.setMaximumSize(new Dimension(PANEL_WIDTH, 40));

        exercisePanel.add(new JLabel(exercise));
        JTextField reps = addTextField(exercisePanel, "Reps: ");
        JTextField sets = addTextField(exercisePanel, "Sets: ");
        JTextField weight = addTextField(exercisePanel, "Weight: ");

        ArrayList<JTextField> addExercise = new ArrayList<>();
        addExercise.add(reps);
        addExercise.add(sets);
        addExercise.add(weight);
        exerciseList.add(addExercise);


        return exercisePanel;
    }
    private JPanel createCalculationPanel() {
        JPanel calculationPanel = new JPanel();
        calculationButton = new JButton("Calculate total weight");
        calculationPanel.add(calculationButton);
        calculationButton.addActionListener(this);
        return calculationPanel;
    }

    private void calculateTotalWeight() {
        double total = 0;
        for (int i = 0; i < exerciseList.size(); i++) {
            ArrayList<JTextField> current = exerciseList.get(i);
            
            try {
                double reps = Double.parseDouble(current.get(0).getText());
                double sets = Double.parseDouble(current.get(1).getText());
                double weight = Double.parseDouble(current.get(2).getText());
                total += reps * sets * weight;
                JOptionPane.showMessageDialog(this,"Total Weight Lifted: " + total + " KG");
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,"Field cannot be empty");
            }
        }
    }
}
