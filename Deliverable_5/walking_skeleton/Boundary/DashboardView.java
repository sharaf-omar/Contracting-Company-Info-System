package Boundary;

import Controller.ProjectManagementController;
import Entity.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The main dashboard view for the ConstructFlow application.
 * Displays a list of projects and provides options to manage them.
 * This is the primary <<boundary>> class for viewing projects.
 */
public class DashboardView extends JFrame {

    private final ProjectManagementController controller;
    private JList<String> projectList;
    private DefaultListModel<String> listModel;

    /**
     * Constructor for the DashboardView.
     */
    public DashboardView() {
        this.controller = new ProjectManagementController();

        // --- Frame Setup ---
        setTitle("ConstructFlow - Projects Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Use BorderLayout

        // --- Header Panel ---
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel titleLabel = new JLabel("All Projects");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // --- Project List Panel (Center) ---
        listModel = new DefaultListModel<>();
        projectList = new JList<>(listModel);
        projectList.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(projectList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Projects"));
        add(scrollPane, BorderLayout.CENTER);

        // --- Button Panel (South) ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        JButton newProjectButton = new JButton("+ New Project");
        buttonPanel.add(newProjectButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // --- Action Listeners ---
        newProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When "New Project" is clicked, open the NewProjectForm
                NewProjectForm newProjectForm = new NewProjectForm(controller, DashboardView.this); // Pass controller and this frame
                newProjectForm.setVisible(true);
            }
        });

        // --- Load Initial Data ---
        refreshProjectList();
    }

    /**
     * Refreshes the list of projects by fetching data from the controller.
     * This method can be called to update the view after a new project is created.
     */
    public void refreshProjectList() {
        System.out.println("View: Refreshing project list...");
        listModel.clear(); // Clear the existing list
        try {
            List<Project> projects = controller.handleFindAllProjects();
            if (projects.isEmpty()) {
                listModel.addElement("No projects found in the database.");
            } else {
                for (Project p : projects) {
                    // Displaying a simple string with ID and Name
                    listModel.addElement("ID: " + p.getProjectID() + " - " + p.getProjectName() + " (" + p.getStatus() + ")");
                }
            }
            System.out.println("View: " + projects.size() + " projects loaded.");
        } catch (Exception e) {
            listModel.addElement("Error loading projects.");
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect to the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * The main entry point for the application.
     */
    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DashboardView().setVisible(true);
            }
        });
    }
}