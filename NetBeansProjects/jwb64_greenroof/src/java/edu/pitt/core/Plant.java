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
 *
 * @author Joseph Beaumont
 */
public class Plant {
    private int plantID;
    private String plantSciName;
    private String plantComName;
    private String habitatNotes;
    private String greenRoofNotes;
    private String birdNotes;
    private int acnpInv;
    private int nativePlant;
    private String flwrColor;
    private String fruitColor;
    private int fruit;
    private String seedColor;
    private int seed;
    private String growthRate;
    private int expHeight;
    private int expSpread;
    private int adaptCourseTextSoil;
    private String droughtTol;
    private String waterUse;
    private double pHMin;
    private double pHMax;
    private int precipMin;
    private int rootDepth;
    private String salinityTol;
    private String shadeTol;
    private int tempMin;
    private int flwrBlmPeriodStart;
    private int flwrBlmPeriodEnd;
    private int fruitSeedPeriodStart;
    private int fruitSeedPeriodEnd;
    private int fruitSeedPersist;
    private int spreadRate;
    private int waterStore;
    private int evergreen;
    
    /**
     * 
     * @param plantID 
     */
    public Plant(int plantID){
        String sql = "SELECT * FROM plants;";
        DbUtilities db = new DbUtilities();
        
        System.out.println(sql);
        try {
            ResultSet rs = db.getResultSet(sql);
            while(rs.next()){
                this.plantID = rs.getInt("plantID");
                this.plantSciName = rs.getString("plantSciName");
                this.plantComName = rs.getString("plantComName");
                this.habitatNotes = rs.getString("habitatNotes");
                this.greenRoofNotes = rs.getString("greenRoofNotes");
                this.birdNotes = rs.getString("birdNotes");
                this.acnpInv = rs.getInt("acnpInv");
                this.nativePlant = rs.getInt("nativePlant");
                this.flwrColor = rs.getString("flwrColor");
                this.fruitColor = rs.getString("fruitColor");
                this.fruit = rs.getInt("fruit");
                this.seedColor = rs.getString("seedColor");
                this.seed = rs.getInt("seed");
                this.growthRate = rs.getString("growthRate");
                this.expHeight = rs.getInt("expHeight");
                this.expSpread = rs.getInt("expSpread");
                this.adaptCourseTextSoil = rs.getInt("adaptCourseTextSoil");
                this.droughtTol = rs.getString("droughtTol");
                this.waterUse = rs.getString("waterUse");
                this.pHMin = rs.getDouble("pHMin");
                this.pHMax = rs.getDouble("pHMax");
                this.precipMin = rs.getInt("precipMin");
                this.rootDepth = rs.getInt("rootDepth");
                this.salinityTol = rs.getString("salinityTol");
                this.shadeTol = rs.getString("shadeTol");
                this.tempMin = rs.getInt("tempMin");
                this.flwrBlmPeriodStart = rs.getInt("flwrBlmPeriodStart");
                this.flwrBlmPeriodEnd = rs.getInt("flwrBlmPeriodEnd");
                this.fruitSeedPeriodStart = rs.getInt("fruitSeedPeriodStart");
                this.fruitSeedPeriodEnd = rs.getInt("fruitSeedPeriodEnd");
                this.fruitSeedPersist = rs.getInt("fruitSeedPersist");
                this.spreadRate = rs.getInt("spreadRate");
                this.waterStore = rs.getInt("waterStore");
                this.evergreen = rs.getInt("evergreen");
                
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            
            
        }
        
    }
    
    
    
    
    public Plant(String plantSciName, String plantComName){
        String sql = "INSERT INTO plants(plantSciName,plantComName) VALUES ";
        sql += "('" + StringUtilities.cleanMySqlInsert(plantSciName) + "', ";
        sql += "'" + StringUtilities.cleanMySqlInsert(plantComName) + "');";
        DbUtilities db = new DbUtilities();
        db.executeQuery(sql);
        this.plantID = db.getLastInsertID("plants", "plantID");
        this.plantSciName = plantSciName;
        this.plantComName = plantComName;
    }
    
    
    
    
    private void updateSingleField(String key, String value){
        String sql = "UPDATE plants SET " + key + " = '" + value + "' WHERE plantID = " + this.plantID;
        System.out.println(sql);
        DbUtilities db = new DbUtilities();
        db.executeQuery(sql);
    }

    /**
     * 
     * @return 
     */
    public int getPlantID() {
        return plantID;
    }

    /**
     * 
     * @return 
     */
    public String getPlantSciName() {
        return plantSciName;
    }

    public void setPlantSciName(String plantSciName) {
        this.updateSingleField("plantSciName", plantSciName);
        this.plantSciName = plantSciName;
    }

    public String getPlantComName() {
        return plantComName;
    }

    public void setPlantComName(String plantComName) {
        this.updateSingleField("plantComName", plantComName);
        this.plantComName = plantComName;
    }

    public String getHabitatNotes() {
        return habitatNotes;
    }

    public void setHabitatNotes(String habitatNotes) {
        this.updateSingleField("habitatNotes", habitatNotes);
        this.habitatNotes = habitatNotes;
    }

    public String getGreenRoofNotes() {
        return greenRoofNotes;
    }

    public void setGreenRoofNotes(String greenRoofNotes) {
        this.updateSingleField("greenRoofNotes", greenRoofNotes);
        this.greenRoofNotes = greenRoofNotes;
    }

    public String getBirdNotes() {
        return birdNotes;
    }

    public void setBirdNotes(String birdNotes) {
        this.updateSingleField("birdNotes", birdNotes);
        this.birdNotes = birdNotes;
    }

    public int getAcnpInv() {
        return acnpInv;
    }

    public void setAcnpInv(int acnpInv) {
        this.updateSingleField("acnpInv", String.valueOf(acnpInv));
        this.acnpInv = acnpInv;
    }

    public int getNativePlant() {
        return nativePlant;
    }

    public void setNativePlant(int nativePlant) {
        this.updateSingleField("nativePlant", String.valueOf(nativePlant));
        this.nativePlant = nativePlant;
    }

    public String getFlwrColor() {
        return flwrColor;
    }

    public void setFlwrColor(String flwrColor) {
        this.updateSingleField("flwrColor", flwrColor);
        this.flwrColor = flwrColor;
    }

    public String getFruitColor() {
        return fruitColor;
    }

    public void setFruitColor(String fruitColor) {
        this.updateSingleField("fruitColor", fruitColor);
        this.fruitColor = fruitColor;
    }

    public int getFruit() {
        return fruit;
    }

    public void setFruit(int fruit) {
        this.updateSingleField("fruit", String.valueOf(fruit));
        this.fruit = fruit;
    }

    public String getSeedColor() {
        return seedColor;
    }

    public void setSeedColor(String seedColor) {
        this.updateSingleField("seedColor", seedColor);
        this.seedColor = seedColor;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.updateSingleField("seed", String.valueOf(seed));
        this.seed = seed;
    }

    public String getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(String growthRate) {
        this.updateSingleField("growthRate", growthRate);
        this.growthRate = growthRate;
    }

    public int getExpHeight() {
        return expHeight;
    }

    public void setExpHeight(int expHeight) {
        this.updateSingleField("expHeight", String.valueOf(expHeight));
        this.expHeight = expHeight;
    }

    public int getExpSpread() {
        return expSpread;
    }

    public void setExpSpread(int expSpread) {
        this.updateSingleField("expSpread", String.valueOf(expSpread));
        this.expSpread = expSpread;
    }

    public int getAdaptCourseTextSoil() {
        return adaptCourseTextSoil;
    }

    public void setAdaptCourseTextSoil(int adaptCourseTextSoil) {
        this.updateSingleField("adaptCourseTextSoil", String.valueOf(adaptCourseTextSoil));
        this.adaptCourseTextSoil = adaptCourseTextSoil;
    }

    public String getDroughtTol() {
        return droughtTol;
    }

    public void setDroughtTol(String droughtTol) {
        this.updateSingleField("droughtTol", droughtTol);
        this.droughtTol = droughtTol;
    }

    public String getWaterUse() {
        return waterUse;
    }

    public void setWaterUse(String waterUse) {
        this.updateSingleField("waterUse", waterUse);
        this.waterUse = waterUse;
    }

    public double getpHMin() {
        return pHMin;
    }

    public void setpHMin(double pHMin) {
        this.updateSingleField("pHMin", String.valueOf(pHMin));
        this.pHMin = pHMin;
    }

    public double getpHMax() {
        return pHMax;
    }

    public void setpHMax(double pHMax) {
        this.updateSingleField("pHMax", String.valueOf(pHMax));
        this.pHMax = pHMax;
    }

    public int getPrecipMin() {
        return precipMin;
    }

    public void setPrecipMin(int precipMin) {
        this.updateSingleField("precipMin", String.valueOf(precipMin));
        this.precipMin = precipMin;
    }

    public int getRootDepth() {
        return rootDepth;
    }

    public void setRootDepth(int rootDepth) {
        this.updateSingleField("rootDepth", String.valueOf(rootDepth));
        this.rootDepth = rootDepth;
    }

    public String getSalinityTol() {
        return salinityTol;
    }

    public void setSalinityTol(String salinityTol) {
        this.updateSingleField("salinityTol", salinityTol);
        this.salinityTol = salinityTol;
    }

    public String getShadeTol() {
        return shadeTol;
    }

    public void setShadeTol(String shadeTol) {
        this.updateSingleField("shadeTol", shadeTol);
        this.shadeTol = shadeTol;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.updateSingleField("tempMin", String.valueOf(tempMin));
        this.tempMin = tempMin;
    }

    public int getFlwrBlmPeriodStart() {
        return flwrBlmPeriodStart;
    }

    public void setFlwrBlmPeriodStart(int flwrBlmPeriodStart) {
        this.updateSingleField("flwrBlmPeriodStart", String.valueOf(flwrBlmPeriodStart));
        this.flwrBlmPeriodStart = flwrBlmPeriodStart;
    }

    public int getFlwrBlmPeriodEnd() {
        return flwrBlmPeriodEnd;
    }

    public void setFlwrBlmPeriodEnd(int flwrBlmPeriodEnd) {
        this.updateSingleField("flwrBlmPeriodEnd", String.valueOf(flwrBlmPeriodEnd));
        this.flwrBlmPeriodEnd = flwrBlmPeriodEnd;
    }

    public int getFruitSeedPeriodStart() {
        return fruitSeedPeriodStart;
    }

    public void setFruitSeedPeriodStart(int fruitSeedPeriodStart) {
        this.updateSingleField("fruitSeedPeriodStart", String.valueOf(fruitSeedPeriodStart));
        this.fruitSeedPeriodStart = fruitSeedPeriodStart;
    }

    public int getFruitSeedPeriodEnd() {
        return fruitSeedPeriodEnd;
    }

    public void setFruitSeedPeriodEnd(int fruitSeedPeriodEnd) {
        this.updateSingleField("fruitSeedPeriodEnd", String.valueOf(fruitSeedPeriodEnd));
        this.fruitSeedPeriodEnd = fruitSeedPeriodEnd;
    }

    public int getFruitSeedPersist() {
        return fruitSeedPersist;
    }

    public void setFruitSeedPersist(int fruitSeedPersist) {
        this.updateSingleField("fruitSeedPersist", String.valueOf(fruitSeedPersist));
        this.fruitSeedPersist = fruitSeedPersist;
    }

    public int getSpreadRate() {
        return spreadRate;
    }

    public void setSpreadRate(int spreadRate) {
        this.updateSingleField("spreadRate", String.valueOf(spreadRate));
        this.spreadRate = spreadRate;
    }

    public int getWaterStore() {
        return waterStore;
    }

    public void setWaterStore(int waterStore) {
        this.updateSingleField("waterStore", String.valueOf(waterStore));
        this.waterStore = waterStore;
    }

    public int getEvergreen() {
        return evergreen;
    }

    public void setEvergreen(int evergreen) {
        this.updateSingleField("evergreen", String.valueOf(evergreen));
        this.evergreen = evergreen;
    }
       
}
