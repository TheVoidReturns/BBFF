package app.scatterlogic.bbff;

import java.util.ArrayList;

/**
 * Created 20/06/2016
 */
public class Player {


    private String name,race,type;
    private int MV,ST,AG,AV;

    private ArrayList<Skill> skills;
    private ArrayList<String> allowedSkillTypes;
    private ArrayList<String> allowedOnDoubleSkillTypes;

    private int Int;
    private int Comp;
    private int TD;
    private int Cas;
    private int Kills;
    private int MVP;

    private int ExtraSPP;
    private int MVInj,STinj,AGInj,AVInj;
    private long value;

    public Player(String race, String type, int MV, int ST, int AG, int AV,long startValue){
        this.race = race;
        this.type = type;
        this.MV = MV;
        this.ST = ST;
        this.AG = AG;
        this.AV = AV;
        Int = 0;
        Comp = 0;
        TD = 0;
        Cas = 0;
        Kills = 0;
        MVP = 0;
        MVInj = 0;
        STinj = 0;
        AGInj = 0;
        AVInj = 0;
        this.value = startValue;
        skills = new ArrayList<Skill>();
        allowedSkillTypes = new ArrayList<String>();
        allowedOnDoubleSkillTypes = new ArrayList<String>();
    }

    public void addAllowedSkill(String skillType){
        allowedSkillTypes.add(skillType);
    }
    public boolean isAllowedSkillType(String skillType){
        boolean outBool = false;
        for (String aSkill : allowedSkillTypes){
            if (aSkill.equals(skillType)) outBool = true;
        }
        return outBool;
    }

    public void addAllowedDoubleSkill(String skillType){
        allowedOnDoubleSkillTypes.add(skillType);
    }
    public boolean isAllowedDoubleSkillType(String skillType){
        boolean outBool = false;
        for (String aSkill : allowedOnDoubleSkillTypes){
            if (aSkill.equals(skillType)) outBool = true;
        }
        return outBool;
    }

    public void addSkill(Skill inSkill){
        skills.add(inSkill);
        if (inSkill.getType().equals("Stat Increase")){
            switch (inSkill.getName()){
                case "MV+":
                    MV = MV + 1;
                    break;
                case "AG+":
                    AG = AG + 1;
                    break;
                case "ST+":
                    ST = ST + 1;
                    break;
                case "AV+":
                    AV = AV + 1;
                    break;

            }
        }
    }
    public boolean hasSkill(Skill skillToCheck){
        boolean outBool = false;
        for (Skill aSkill : skills){
            if (aSkill.getName().equals(skillToCheck.getName())) outBool = true;
        }
        return outBool;
    }
    public boolean hasSkill(String skillToCheck){
        boolean outBool = false;
        for (Skill aSkill : skills){
            if (aSkill.getName().equals(skillToCheck)) outBool = true;
        }
        return outBool;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }
    public String getType() {
        return type;
    }

    public int getMV() {
        return MV + MVInj;
    }
    public int getST() {
        return ST + STinj;
    }
    public int getAG() {
        return AG + AGInj;
    }
    public int getAV() {
        return AV + AVInj;
    }

    public int getInt() {
        return Int;
    }
    public void addInt(){Int = Int + 1;}
    public void subInt(){Int = Int - 1;}

    public int getComp() {
        return Comp;
    }
    public void addComp(){Comp = Comp + 1;}
    public void subComp(){Comp = Comp - 1;}

    public int getTD() {
        return TD;
    }
    public void addTD(){TD = TD + 1;}
    public void subTD(){TD = TD - 1;}

    public int getCas() {
        return Cas;
    }
    public void addCas(){Cas = Cas + 1;}
    public void subCas(){Cas = Cas - 1;}

    public int getKills() {
        return Kills;
    }
    public void addKills(){Kills = Kills + 1;}
    public void subKills(){Kills = Kills - 1;}

    public int getMVP() {
        return MVP;
    }
    public void addMVP(){MVP = MVP + 1;}
    public void subMVP(){MVP = MVP - 1;}

    public int getExtraSPP() {
        return ExtraSPP;
    }
    public void giveExtraSPP(int numberOfSPPsToGive){
        ExtraSPP = ExtraSPP + numberOfSPPsToGive;
    }

    public int getMVInj() {
        return MVInj;
    }
    public void addMVInj(){MVInj = MVInj + 1;}
    public void subMVInj(){MVInj = MVInj - 1;}

    public int getSTinj() {
        return STinj;
    }
    public void addSTinj(){STinj = STinj + 1;}
    public void subSTinj(){STinj = STinj - 1;}

    public int getAGInj() {
        return AGInj;
    }
    public void addAGInj(){AGInj = AGInj + 1;}
    public void subAGInj(){AGInj = AGInj - 1;}

    public int getAVInj() {
        return AVInj;
    }
    public void addAVInj(){AVInj = AVInj + 1;}
    public void subAVInj(){AVInj = AVInj - 1;}

    public long getValue() {
        long extras = 0;
        boolean outBool = false;
        for (Skill aSkill : skills){
            if (aSkill.getName().equals("ST+")) extras = extras + 50000;
            else if (aSkill.getName().equals("AG+")) extras = extras + 40000;
            else if (aSkill.getName().equals("AV+")) extras = extras + 30000;
            else if (aSkill.getName().equals("MA+")) extras = extras + 30000;
            else if (isAllowedDoubleSkillType(aSkill.getType())) extras = extras + 30000;
            else extras = extras + 20000;
        }
        return value + extras;
    }



}
