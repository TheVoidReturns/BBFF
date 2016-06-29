package app.scatterlogic.bbff;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class skillBook {
    private ArrayList<Skill> skillBook;
    Context context;

    public skillBook(Context c){
        context=c;
        skillBook = new ArrayList<Skill>();
        fillSkillBook();
        //debugTest();
    }
    public void add(Skill skillToAdd){
        skillBook.add(skillToAdd);
    }
    public ArrayList<Skill> getSkillBook() {
        return skillBook;
    }
    public  ArrayList<Skill> getAllSkillsRelatedTo(String thingToLookFor){
        ArrayList<Skill> returnList = new ArrayList<Skill>();
        Skill tempSkill;
        for (int i = 0; i <= skillBook.size();i++){
            tempSkill = skillBook.get(i);
            if (tempSkill.relatesTo(thingToLookFor)) returnList.add(tempSkill);
        }
        return returnList;
    }
    public  ArrayList<Skill> getAllSkillsOfType(String thingToLookFor){
        ArrayList<Skill> returnList = new ArrayList<Skill>();
        Skill tempSkill;
        for (int i = 0; i <= skillBook.size();i++){
            tempSkill = skillBook.get(i);
            if (tempSkill.getType().contains(thingToLookFor)) returnList.add(tempSkill);
        }
        return returnList;
    }
    public void fillSkillBook(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getResources().openRawResource(R.raw.bbskills)));

            // do reading, usually loop until end of file reading
            int skillCounter = 0;
            Skill tempSkill = new Skill("Error");
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                mLine = mLine.trim();
                //Is this a skill title line?
//                if (mLine.lastIndexOf(")")>=1) {
//                    Log.d("Bracket finding", "( at " + mLine.lastIndexOf("("));
//                    Log.d("Bracket finding", ") at " + mLine.lastIndexOf(")"));
//                    Log.d("String reading test", "About to read " + mLine);
//                }

                if (mLine.length() >= 1) {
                    if (((mLine.charAt(mLine.length() - 1) + "").equalsIgnoreCase(")"))&&(Character.isUpperCase(mLine.charAt(0)))) {
                        //we need to separate the skill name from the type
                        Log.d("TempSkill is", tempSkill.getName());
                        if (!tempSkill.getName().equals("Error")) skillBook.add(tempSkill);
                        String skillName = mLine.substring(0, mLine.lastIndexOf("(") - 1);
                        String skillType = mLine.substring(mLine.lastIndexOf("(") + 1, mLine.length() - 1);
                        tempSkill = new Skill(skillName);
                        tempSkill.setType(skillType);
                    } else //it's a text line
                    {
                        if (!((mLine==null)||mLine.equals("null")))
                        tempSkill.setText(tempSkill.getText() + " " + mLine);
                    }

                }
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        //add Stat Increases
        Skill MVPlus = new Skill("MV+");
        MVPlus.setType("Stat Increase");
        skillBook.add(MVPlus);

        Skill AGPlus = new Skill("AG+");
        AGPlus.setType("Stat Increase");
        skillBook.add(AGPlus);

        Skill STPlus = new Skill("ST+");
        STPlus.setType("Stat Increase");
        skillBook.add(STPlus);

        Skill AVPlus = new Skill("AV+");
        AVPlus.setType("Stat Increase");
        skillBook.add(AVPlus);
    }
    public void debugTest(){
        for (int i = 0; i<skillBook.size();i++){
            Skill tempSkill = skillBook.get(i);
            Log.d("Post Event...", tempSkill.getName() + ", " + tempSkill.getType()+ ", " + tempSkill.getText());
        }
    }

}
