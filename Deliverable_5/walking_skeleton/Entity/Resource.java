package Entity;

import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class Resource {

    /**
     * Default constructor
     */
    public Resource() {
    }

    /**
     * 
     */
    public void resourceID:Int {key};

    /**
     * 
     */
    public void resourceName: String;

    /**
     * 
     */
    public void quantityIntStock: Int;

    /**
     * 
     */
    public int reorderThreshold;



    /**
     * @param quantityChange 
     * @return
     */
    public void updateStock(double quantityChange) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public boolean isBelowThreshold() {
        // TODO implement here
        return false;
    }

}