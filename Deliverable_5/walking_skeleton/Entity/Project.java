package Entity;

import java.io.*;
import java.util.*;

public class Project {

    private int projectID;
    private String projectName;
    private Date endDate;
    private String location;
    private Date startDate;
    private String status;

    // Getters
    public int getProjectID() {
        return projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getStatus() {
        return status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    // Setters
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @param taskID 
     * @return
     */
    public Task findTaskInProject(int taskID) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void archive() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public boolean canBeArchived() {
        // TODO implement here
        return false;
    }

    /**
     * @param details
     */
    public Project(Map details) {
        // TODO implement here
    }

    /**
     * @param budget 
     * @return
     */
    public void setBudget(Budget budget) {
        // TODO implement here
        return null;
    }

}