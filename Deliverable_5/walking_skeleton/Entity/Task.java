package Entity;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Task {

    /**
     * Default constructor
     */
    public Task() {
    }

    /**
     * 
     */
    public Int {key} taskID;

    /**
     * 
     */
    public String taskName;

    /**
     * 
     */
    public String status;

    /**
     * 
     */
    public Date dueDate;

    /**
     * 
     */
    public String description;




    /**
     * @return
     */
    public void cancel() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public boolean canBeCancelled() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public void lock() {
        // TODO implement here
        return null;
    }

    /**
     * @param newStatus 
     * @return
     */
    public void updateStatus(String newStatus) {
        // TODO implement here
        return null;
    }

}