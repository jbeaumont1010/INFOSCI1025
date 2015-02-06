 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.core;

import edu.pitt.utilities.DbUtilities;
import edu.pitt.utilities.StringUtilities;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Creates the class, Bird, and creates private properties that
 * match all the fields in the jwb64_greenroof database table birds
 * @author Joseph Beaumont
 */
public class Bird {
    private int birdID;
    private String birdSciName;
    private String birdComName;
    private String iucnListing;
    private String amjvPriority;
    private int paWAP;
    private String migratoryStatus;
    private int springMigPeriodStart;
    private int springMigPeriodEnd;
    private int fallMigPeriodStart;
    private int fallMigPeriodEnd;
    private String specPlants;
    private String notes;
    
    /**
     * Constructor of the Bird class that takes one parameter.
     * String variable sql is a SELECT SQL statement that concatenates the
     * parameter into a SQL statement to query a specific bird based on
     * @param birdID 
     */
    public Bird(int birdID){
        String sql = "SELECT * FROM birds WHERE birdID = " + birdID + ";";
        DbUtilities db = new DbUtilities();
        
        System.out.println(sql);
        try {
            ResultSet rs = db.getResultSet(sql);
            while(rs.next()){
                this.birdID = rs.getInt("birdID");
                this.birdSciName = rs.getString("birdSciName");
                this.birdComName = rs.getString("birdComName");
                this.iucnListing = rs.getString("iucnListing");
                this.amjvPriority = rs.getString("amjvPriority");
                this.paWAP = rs.getInt("paWAP");
                this.migratoryStatus = rs.getString("migratoryStatus");
                this.springMigPeriodStart = rs.getInt("springMigPeriodStart");
                this.springMigPeriodEnd = rs.getInt("springMigPeriodEnd");
                this.fallMigPeriodStart = rs.getInt("fallMigPeriodStart");
                this.fallMigPeriodEnd = rs.getInt("fallMigPeriodEnd");
                this.specPlants = rs.getString("specPlants");
                this.notes = rs.getString("notes");
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        
    }
    /**
     * 
     * @param birdSciName
     * @param birdComName 
     */
    public Bird(String birdSciName, String birdComName){
            String sql = "INSERT INTO birds(birdSciName,birdComName) VALUES ";
            sql += "('" + StringUtilities.cleanMySqlInsert(birdSciName) + "', ";
            sql += "'" + StringUtilities.cleanMySqlInsert(birdComName) + "');";
            DbUtilities db = new DbUtilities();
            db.executeQuery(sql);
            this.birdID = db.getLastInsertID("birds", "birdID");
            this.birdSciName = birdSciName;
            this.birdComName = birdComName;
    }
    
    /**
     * 
     * @param key
     * @param value 
     */
    private void updateSingleField(String key, String value){
        String sql = "UPDATE birds SET " + key + " = '" + value + "' WHERE birdID = " + this.birdID;
        System.out.println(sql);
        DbUtilities db = new DbUtilities();
        db.executeQuery(sql);
    }
    
    private void updateSingleField(String key, int value){
        String sql = "UPDATE birds SET " + key + " = '" + value + "' WHERE birdID = " + this.birdID;
        System.out.println(sql);
        DbUtilities db = new DbUtilities();
        db.executeQuery(sql);
    }    

    /**
     * @return the birdID
     */
    public int getBirdID() {
        return birdID;
    }

    /**
     * @return the birdSciName
     */
    public String getBirdSciName() {
        return birdSciName;
    }

    /**
     * @param birdSciName the birdSciName to set
     */
    public void setBirdSciName(String birdSciName) {
        this.updateSingleField("birdSciName", birdSciName);
        this.birdSciName = birdSciName;
    }

    /**
     * @return the birdComName
     */
    public String getBirdComName() {
        return birdComName;
    }

    /**
     * @param birdComName the birdComName to set
     */
    public void setBirdComName(String birdComName) {
        this.updateSingleField("birdComName", birdComName);
        this.birdComName = birdComName;
    }

    /**
     * @return the iucnListing
     */
    public String getIucnListing() {
        return iucnListing;
    }

    /**
     * @param iucnListing the iucnListing to set
     */
    public void setIucnListing(String iucnListing) {
        this.updateSingleField("iucnListing", iucnListing);
        this.iucnListing = iucnListing;
    }

    /**
     * @return the amjvPriority
     */
    public String getAmjvPriority() {
        return amjvPriority;
    }

    /**
     * @param amjvPriority the amjvPriority to set
     */
    public void setAmjvPriority(String amjvPriority) {
        this.updateSingleField("amjvPriority", amjvPriority);
        this.amjvPriority = amjvPriority;
    }

    /**
     * @return the paWAP
     */
    public int getPaWAP() {
        return paWAP;
    }

    /**
     * @param paWAP the paWAP to set
     */
    public void setPaWAP(int paWAP) {
        this.updateSingleField("paWAP", String.valueOf(paWAP));
        this.paWAP = paWAP;
    }

    /**
     * @return the migratoryStatus
     */
    public String getMigratoryStatus() {
        return migratoryStatus;
    }

    /**
     * @param migratoryStatus the migratoryStatus to set
     */
    public void setMigratoryStatus(String migratoryStatus) {
        this.updateSingleField("migratoryStatus", migratoryStatus);
        this.migratoryStatus = migratoryStatus;
    }

    /**
     * @return the springMigPeriodStart
     */
    public int getSpringMigPeriodStart() {
        return springMigPeriodStart;
    }

    /**
     * @param springMigPeriodStart the springMigPeriodStart to set
     */
    public void setSpringMigPeriodStart(int springMigPeriodStart) {
        this.updateSingleField("springMigPeriodStart", String.valueOf(springMigPeriodStart));
        this.springMigPeriodStart = springMigPeriodStart;
    }

    /**
     * @return the springMigPeriodEnd
     */
    public int getSpringMigPeriodEnd() {
        return springMigPeriodEnd;
    }

    /**
     * @param springMigPeriodEnd the springMigPeriodEnd to set
     */
    public void setSpringMigPeriodEnd(int springMigPeriodEnd) {
        this.updateSingleField("springMigPeriodEnd", String.valueOf(springMigPeriodEnd));
        this.springMigPeriodEnd = springMigPeriodEnd;
    }

    /**
     * @return the fallMigPeriodStart
     */
    public int getFallMigPeriodStart() {
        return fallMigPeriodStart;
    }

    /**
     * @param fallMigPeriodStart the fallMigPeriodStart to set
     */
    public void setFallMigPeriodStart(int fallMigPeriodStart) {
        this.updateSingleField("fallMigPeriodStart", String.valueOf(fallMigPeriodStart));
        this.fallMigPeriodStart = fallMigPeriodStart;
    }

    /**
     * @return the fallMigPeriodEnd
     */
    public int getFallMigPeriodEnd() {
        return fallMigPeriodEnd;
    }

    /**
     * @param fallMigPeriodEnd the fallMigPeriodEnd to set
     */
    public void setFallMigPeriodEnd(int fallMigPeriodEnd) {
        this.updateSingleField("fallMigPeriodEnd", String.valueOf(fallMigPeriodEnd));
        this.fallMigPeriodEnd = fallMigPeriodEnd;
    }

    /**
     * @return the specPlants
     */
    public String getSpecPlants() {
        return specPlants;
    }

    /**
     * @param specPlants the specPlants to set
     */
    public void setSpecPlants(String specPlants) {
        this.updateSingleField("specPlants", specPlants);
        this.specPlants = specPlants;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.updateSingleField("notes", notes);
        this.notes = notes;
    }
    
    
    
    
}
