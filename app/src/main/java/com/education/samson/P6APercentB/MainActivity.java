package com.education.samson.G8NumberTheory;

import android.content.Intent;
import android.provider.Settings.Secure;
import android.net.Uri;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static final int totalQuest = 22; //number of questions
    int questCount = 20; //count the question
    int questSubcount = 0; //count the times of doing similar questions
    int pagePassword = 2; //page that requires password
    int falseInSubQuest = 0; //times of false in a question
    int answered = 0; //answered a MC already? Yes-1, No-0
    int labelTag = 0; //to recognize which label is pressed
    int viewTag = 0; //to recognize which view is pressed
    int thisIsCorrect = 0;//to record the question is correctly answered
    int[] oldScore = {0, 0, 0};//start of the animation of score increase
    int[] newScore = {0, 0, 0}; //end of the animation of score increase
    int currentScore = 0; //current score of the animation of score increase
    int digit = 0; //which digit animating
    int woodenWholeDigit = 0; //number of digits of whole number
    double woodenWholeLastValue = 1.0; //the value of last digit of whole number
    int woodenWholeDecNum = -1; //number of decimals of whole number
    double[] woodenValue = {0.0, 0.0, 0.0};//initialize the values of answer fraction
    int woodenChosen = 3;//which wooden board the user is inputing[0, 1, 2], 3 means not choose yet
    int buttonPressed = 0; //the R.id of the button pressed
    int buttonIndex = -1; //the index of the button pressed in the array
    int ansFormat = 1; //0 for MC, 1 for fill in the blank
    int ID = 0; //create App ID by class + random number
    double password = 0; //calculated password
    int[] passDigit = {0, 0, 0, 0, 0, 0}; //digit array for calculating the password
    String responseFile = ""; //file name of audio of response
    int maxCount = 9;    //Maximum Count to which label will be Updated
    int currentCount = 0;     // Count which is currently displayed in Label
    int form = 6; //exercise for class 5 2nd term
    int term = 1; //exercise for class 5 2nd term
    Handler handler; //more stable than timer to repeat the action of increasing score
    Runnable periodicUpdate; //the runnable function of the action of increasing score
    boolean Continue = false; //Is periodicUpdate continue?

    private static final int[] BUTTON_IDS = {
            R.id.Image110, R.id.Image111, R.id.MImage112, R.id.MImage113, R.id.OOkButton, R.id.RRestart
    }; //IDs of buttonMC x 4, OkButton and Restart button
    private static final int[] BUTTON_Square = {
            R.id.S0, R.id.S1, R.id.S2, R.id.S3, R.id.S4, R.id.S5,
            R.id.S6, R.id.S7, R.id.S8, R.id.S9, R.id.Square10, R.id.SquareBackButton
    }; //IDs of 11 small square buttons
    private static final int[] BUTTON_Wooden = {
            R.id.wooden0, R.id.wooden1, R.id.wooden2
    };//IDs of 3 wooden board textViews
    private static final int[] MCColorID = {
            R.id.LinearLayout110, R.id.LinearLayout111, R.id.LinearLayout112, R.id.LinearLayout113
    }; //IDs of 4 buttonMC background for changing button colors

    TextView[] woodenNumber; //wooden board textView for changing the number
    TextView[] score; //textView to display the score
    ImageView[] buttonsMC = new ImageView[4]; //answer buttons for MC
    ImageView fillInBlank; //blue button view for fill in blank
    LinearLayout[] MCButtonColor = new LinearLayout[4];//color buttons for MC
    TextView OkButton; //Ok button textView for changing the text
    TextView restartButton; //Restart button
    ImageView responseView; //to display response png
    ImageView questionView; //to display question png
    ImageView shiningStar1; //for the animation of a shining star to get the attention on the question
    ImageView shiningStar2; //for the animation of a shining star to get the attention on the response
    TextView decimalView; //square to display "."
    TextView textID; //to display user ID on the right bottom corner
    TextView textGood; // for the animation of the GOOD message
    TextView textTry; //for the animation of the TRY AGAIN message
    LinearLayout layoutMC1; //1st row of MC for switch between MC and fill in blanks
    LinearLayout layoutMC2; //2nd row of MC for switch between MC and fill in blanks
    LinearLayout layoutWooden; //row of wooden boards for switch between MC and fill in blanks
    LinearLayout layoutFraction; // layout to display fraction and its visibility
    LinearLayout layoutSquare; //row of small squares for switch between MC and fill in blanks
    MediaPlayer click; //for Ok button
    MediaPlayer clap; //for correct answer
    MediaPlayer ding; //for displaying response
    MediaPlayer chimes; //2nd choice for correct answer
    MediaPlayer responsePlayer; //player for playing the response audio

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setup the players with audios
        chimes = MediaPlayer.create(this, R.raw.chimes);
        clap = MediaPlayer.create(this, R.raw.clap);
        ding = MediaPlayer.create(this, R.raw.ding);
        click = MediaPlayer.create(this, R.raw.click);

        //match ID in .xml
        responseView = (ImageView) findViewById(R.id.Response);
        layoutSquare = (LinearLayout) findViewById(R.id.LinearLayout1_3);
        woodenNumber = new TextView[BUTTON_Wooden.length];
        buttonsMC = new ImageView[BUTTON_IDS.length - 2];
        score = new TextView[3];
        score[0] = (TextView) findViewById(R.id.Coin0);
        score[1] = (TextView) findViewById(R.id.Coin1);
        score[2] = (TextView) findViewById(R.id.Coin2);
        fillInBlank = (ImageView) findViewById(R.id.Image120);
        responseView = (ImageView) findViewById(R.id.Response);
        questionView = (ImageView) findViewById(R.id.Image0);
        shiningStar1 = (ImageView) findViewById(R.id.shiningstar1);
        shiningStar2 = (ImageView) findViewById(R.id.shiningstar2);
        textID = (TextView) findViewById(R.id.TextID);
        textGood = (TextView) findViewById(R.id.GoodLabel);
        textTry = (TextView) findViewById(R.id.TryLabel);
        layoutMC1 = (LinearLayout) findViewById(R.id.LinearLayout1_1_0);
        layoutMC2 = (LinearLayout) findViewById(R.id.LinearLayout1_1_1);
        layoutWooden = (LinearLayout) findViewById(R.id.LinearLayout1_2);
        layoutFraction = (LinearLayout) findViewById(R.id.LinearLayoutFraction);
        layoutSquare = (LinearLayout) findViewById(R.id.LinearLayout1_3);
        OkButton = findViewById(BUTTON_IDS[4]);
        restartButton = findViewById(BUTTON_IDS[5]);
        decimalView = (TextView) findViewById(R.id.Square10);
        handler = new Handler(); //used as timer


        //get ANDROID_ID that does not need permission
        String androidId = Secure.getString(getContentResolver(), Secure.ANDROID_ID);
        //use last hex digits only
        int androidIdInt = Integer.parseInt(androidId.substring(androidId.length() - 3), androidId.length());
        //value between 0 and 4095. Put into 4 digits
        int temp = androidIdInt;
        int d1 = (int)Math.floor(temp / 1000);
        temp = temp - d1 * 1000;
        int d2 = (int)Math.floor(temp/100);
        temp = temp - d2 * 100;
        int d3 = (int)Math.floor(temp/10);
        int d4 = temp - d3 * 10;
        //calculate ID with form, term and androidIDInt
        ID = (int)((form * 10 + term) * 10000 + androidIdInt + Math.abs(term * 3 - d1) * 197 + Math.pow((term * 4) - d3, 2) * 13 + Math.pow(form - d2, 2) * 11 + Math.abs(form - d4) * 119);
        //put ID into 6 digits
        int IDTemp = ID;
        int tens = 100000;
        for (int i = 0; i < 6; i++) {
            passDigit[i] = (int) (IDTemp / tens);
            IDTemp -= passDigit[i] * tens;
            tens = tens / 10;
        }
        //calculate the password with 6 digits
        password = Math.pow(passDigit[0], 3) * 17 + Math.pow(passDigit[1], 2) * 173 + Math.pow(passDigit[2], 3) * 83 + Math.pow(passDigit[3], 2) * 679 + passDigit[4] * 2989 + Math.pow(passDigit[5], 2) * 497;
        //display user ID
        textID.setText("請先按一下木板才按數字。       ID=" + String.valueOf(ID));
        //setup button Listener
        View.OnClickListener buttonListener = new View.OnClickListener(){
            public void onClick(View v){
                buttonPressed = v.getId();
                if (Arrays.binarySearch(BUTTON_IDS, buttonPressed) > -1) {
                    buttonIndex = Arrays.binarySearch(BUTTON_IDS, buttonPressed);
                    labelTag = buttonIndex;
                    Buttons(); //action for buttonMC, Okbutton and Restart button
                }
                if (Arrays.binarySearch(BUTTON_Square, buttonPressed) > -1) {
                    buttonIndex = Arrays.binarySearch(BUTTON_Square, buttonPressed);
                    labelTag = buttonIndex;
                    Square(); //action for small square buttons
                }
                if (Arrays.binarySearch(BUTTON_Wooden, buttonPressed) > -1) {
                    buttonIndex = Arrays.binarySearch(BUTTON_Wooden, buttonPressed);
                    labelTag = buttonIndex;
                    Wooden(); //action for 3 wooden board
                }
                if (buttonPressed == R.id.Response){
                    //action for pressing the hyperlink to Facebook
                    if (questCount == pagePassword){
                        String url = "https://www.facebook.com/primarymathspaper/posts/2509015912489319";
                        Uri uriUrl = Uri.parse(url);
                        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                        startActivity(launchBrowser);
                    }
                }
            }
        };
        OkButton.setOnClickListener(buttonListener);
        restartButton.setOnClickListener(buttonListener);
        responseView.setOnClickListener(buttonListener);
        for (int i=0; i< BUTTON_IDS.length - 2; i++) {
            ImageView button = (ImageView) findViewById(BUTTON_IDS[i]);
            button.setOnClickListener(buttonListener); // maybe
            if (i < 4){
                buttonsMC[i] = button;
                MCButtonColor[i] = (LinearLayout) findViewById(MCColorID[i]);
            }
        }
        for (int buttonID : BUTTON_Square) {
            View button = (View) findViewById(buttonID);
            button.setOnClickListener(buttonListener); // maybe
        }
        for (int i=0; i<BUTTON_Wooden.length; i++) {
            TextView button = (TextView) findViewById(BUTTON_Wooden[i]);
            button.setOnClickListener(buttonListener); // maybe
            woodenNumber[i] = button;
        }
        SetText(); //setup all text and image for next question
    }

    //Actions of buttonMC, Okbutton, Restart button
    void Buttons(){
        labelTag = buttonIndex;
        if (labelTag == 5) { //Restart button
            startAgain();
        }
        //fill in blank format. when ok button is pressed, check answer
        if (ansFormat == 1) { //fill in blank
            if (labelTag == 4) { //Okbutton
                if (answered == 0) { //have not answered yet
                    if (questCount != pagePassword) { //other than password page
                        answeringAction();
                    }
                    checkBlank(); //check answer, also password
                }
                else { //have answered already
                    if (questCount == pagePassword) {
                        okPassword(); //press Okbutton on password page
                    }
                    else {
                        okButton(); //press Okbutton on other pages
                    }
                    answered = 0; //set to unanswered
                    OkButton.setText("確定"); //display it again
                    OkButton.setTextColor(0xff000000); //set text color to black
                }
            }
        }
        //MC format
        else if (ansFormat == 0) { //MC
            //if year == savedYear || year == savedYear + 1 && month <= savedMonth {
            //if unanswered, response to MC answer before the last conclusion page
            if (answered == 0 && labelTag < 4 && questCount < totalQuest) {
                answered = 1; //set it to having answered already
                answeringAction();
                pressAnswer();
            }
            //if answered, press okButton to next quest or subquest before the last conclusion page
            else if (answered == 1 && labelTag == 4 && questCount < totalQuest) {
                answered = 0;
                okButton();
            }
            else {}

        /*else {
            for i in 1 ... 15 {
                label[i].latex = ""}
            label[1].latex = "已經過了一年期限。"
        }*/
        }

    }


    //actions for numbers are pressed at fill in the blank
    void Square(){
        //action only at fill in the blank
        if (ansFormat == 1 && answered == 0){
            //which view is pressed?
            viewTag = buttonIndex;
            //action when 0-9 is pressed and fraction wooden is chosen and not 3 digits yet
            if (woodenChosen < 3 && woodenChosen > -1 && dataBase.nonFraction[questCount] == 0 && viewTag < 10){
                if (woodenValue[woodenChosen] < 100) {
                    woodenValue[woodenChosen] = woodenValue[woodenChosen] * 10 + viewTag;
                    //not display 0 in any part of fraction
                    if (woodenValue[woodenChosen] == 0) {
                        woodenNumber[woodenChosen].setText("");
                    }
                    else {
                        //display whole number only without decimal
                        woodenNumber[woodenChosen].setText(String.format("%.0f", woodenValue[woodenChosen]));
                    }
                }
            }
            //when the answer is not a fraction and 0-9 is chosen
            else if (woodenChosen == 0 && dataBase.nonFraction[questCount] == 1 && viewTag < 11) {
                //add digit when fewer than 7 digits
                if (woodenWholeDigit < 6) {
                    //add decimal
                    if (viewTag == 10) { // viewTag == 10 for "."
                        //add decimal only when there is none
                        if (woodenWholeDecNum == -1) { //whole number without decimal
                            woodenWholeDecNum = 0; //whole number with "."
                            //no digit when whole number is 0, so it counts 1 digit when it is a decimal
                            if (woodenValue[woodenChosen] == 0) {woodenWholeDigit += 1;}
                            woodenNumber[0].setText(String.format("%.0f", woodenValue[woodenChosen]) + ".");
                        }
                    }
                    //add number
                    else {
                        //add whole number
                        woodenWholeDigit += 1;
                        if (woodenWholeDecNum == -1) { //whole number
                            woodenValue[woodenChosen] = woodenValue[woodenChosen] * 10 + viewTag;
                                    if (woodenWholeDigit == 1 && woodenValue[woodenChosen] == 0) {woodenWholeDigit -= 1;}
                            woodenNumber[woodenChosen].setText(String.format("%.0f", woodenValue[woodenChosen]));
                        }
                        else { //add decimal number
                            woodenWholeLastValue = woodenWholeLastValue * 10;
                            woodenWholeDecNum += 1;
                            woodenValue[0] += viewTag / woodenWholeLastValue;
                            String Format = "%." + String.valueOf(woodenWholeDecNum) +"f"; //number of decimal digits
                            woodenNumber[woodenChosen].setText(String.format(Format, woodenValue[woodenChosen]));
                        }
                    }
                }
            }
            // when backbutton is pressed and decimal number wooden is chosen
            else if (viewTag == 11 && woodenChosen == 0 && dataBase.nonFraction[questCount] ==1) {
                //back the whole number
                if (woodenWholeDecNum < 1){
                    woodenWholeDecNum = -1;
                    woodenWholeDigit -= 1;
                    woodenValue[0] = (Double)Math.floor(woodenValue[0] / 10);
                    woodenNumber[0].setText(String.format("%.0f", woodenValue[woodenChosen]));
                    if (woodenValue[0] == 0) { //do not display whole number "0"
                        woodenNumber[0].setText("");
                        woodenWholeDigit = 0;
                    }
                }
                //back the decimal number
                else {
                    woodenWholeLastValue = woodenWholeLastValue / 10;
                    woodenWholeDigit -= 1;
                    woodenWholeDecNum -= 1;
                    woodenValue[0] = (Double) (Math.floor(woodenValue[0] * woodenWholeLastValue) / woodenWholeLastValue);
                    String Format = "%." + String.valueOf(woodenWholeDecNum) +"f"; //number of decimal digit
                    woodenNumber[woodenChosen].setText(String.format(Format, woodenValue[woodenChosen]));
                    if (woodenWholeDecNum == 0) {
                        woodenWholeDecNum = -1; //become a whole number
                    }
                }
            }
            //back the 3 numbers of fraction
            else if (viewTag == 11 && woodenChosen < 3 && woodenChosen > -1 ){
                woodenValue[woodenChosen] = (Double)Math.floor(woodenValue[woodenChosen] / 10);
                //not display 0 in any part of fraction
                if (woodenValue[woodenChosen] == 0) {
                    woodenNumber[woodenChosen].setText("");
                }
                else { //whole number without decimal
                    woodenNumber[woodenChosen].setText(String.format("%.0f", woodenValue[woodenChosen]));
                }
            }
        }
    }

    void Wooden(){
        woodenChosen = buttonIndex;
        //set the chosen wood brighter
        for (int i = 0; i < 3; i++) {
            woodenNumber[i].setBackgroundColor(0x00FFFFFF); // wooden textView background transparent
        }
        woodenNumber[woodenChosen].setBackgroundColor(0x66FFFFFF); //chosen textView background brighter with white color
    }

    void startAgain(){ //Restart the app to the first question
        click.start();
        //reset all counting variables
        questCount = 0;
        questSubcount = 0;
        falseInSubQuest = 0;
        thisIsCorrect = 0;
        answered = 0;
        OkButton.setTextColor(0x00000000); //no text displayed on Okbutton
        currentScore = 0;
        for (int i = 0; i < 3; i++){
            woodenNumber[i].setText(""); //clear 3 wooden boards
            woodenValue[i] = 0.0;
            score[i].setText("0"); //reset the score to 0
        }
        woodenWholeLastValue = 1;
        woodenWholeDecNum = -1;
        woodenWholeDigit = 0;
        SetText(); //set the text and image for the first question
    }

    void answeringAction(){ //actions for user answers
        ding.start(); //ding sound and shining star get the attention of user
        shiningStar2.setVisibility(View.VISIBLE);
        Animation star2Animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.staranim);
        shiningStar2.startAnimation(star2Animation);
        shiningStar2.setVisibility(View.INVISIBLE);
    }

    void checkBlank(){ //check the answer of fill in blank
        if (questCount == pagePassword) { //password page
            answered = 1;
            thisIsCorrect = 0;
            OkButton.setText("密碼不正確"); //default is incorrect

            if (woodenValue[0] == password) { //whole number board gets correct password
                thisIsCorrect = 1;
                OkButton.setText("下一題");
            }
        }
        else {
            answered = 1; //pages other than password page
            thisIsCorrect = 0;
            OkButton.setText("再算一算"); // default is incorrect
            //default is the last one of 4 responses
            responseView.setImageResource(dataBase.responseView[questCount][questSubcount][3]);
            responsePlayer = MediaPlayer.create(getApplicationContext(), dataBase.audioFile[questCount][questSubcount][3]);
            for (int i = 0; i < 4 ; i++ ) { //check it equals to 1 of 4 responses
                if (Math.abs(woodenValue[0] - dataBase.blankAnswer[questCount][questSubcount][i][0]) < 0.000001
                && Math.abs(woodenValue[1] - dataBase.blankAnswer[questCount][questSubcount][i][1]) < 0.000001
                && Math.abs(woodenValue[2] - dataBase.blankAnswer[questCount][questSubcount][i][2]) < 0.000001) {
                //if (Arrays.equals(woodenValue, dataBase.blankAnswer[questCount][questSubcount][i])) {
                    //set its corresponding response
                    responseView.setImageResource(dataBase.responseView[questCount][questSubcount][i]);
                    //check if it is correct
                    if (i == 0) {
                        thisIsCorrect = 1;
                        OkButton.setText("下一題");
                    }
                responsePlayer = MediaPlayer.create(getApplicationContext(), dataBase.audioFile[questCount][questSubcount][i]);
                }

            }
            responsePlayer.start();
            falseInSubQuest += (1 - thisIsCorrect); //falseInSubQuest plus 1 when it is wrong
        }

    }

    void okPassword(){ //press ok button on password page
        click.start();
        if (labelTag == 4) { //ok button
            if (thisIsCorrect == 1) { //correct password
                thisIsCorrect = 0; //set default for next question
                for (int i = 0; i < 3; i++){ //reset wooden board
                    woodenNumber[i].setText("");
                    woodenValue[i] = 0.0;
                }
                //reset variables for next page
                woodenWholeLastValue = 1;
                woodenWholeDecNum = -1;
                woodenWholeDigit = 0;
                woodenWholeLastValue = 1;
                woodenWholeDecNum = -1;
                woodenWholeDigit = 0;
                questCount += 1;
                if (questCount == 2) {questCount = 3;}//no password page
                questSubcount = 0;
                falseInSubQuest = 0;
                shiningStar1.setVisibility(View.VISIBLE);
                Animation starAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.staranim);
                shiningStar1.startAnimation(starAnimation);
                shiningStar1.setVisibility(View.INVISIBLE);
                SetText();
            }
            else { //incorrect password
                click.start();
                if (ansFormat == 1) {
                    for (int i = 0; i < 3; i++){ //reset the wooden board for inputting password again
                        woodenNumber[i].setText("");
                        woodenValue[i] = 0.0;
                    }
                    //reset variables about wooden board
                    woodenWholeLastValue = 1;
                    woodenWholeDecNum = -1;
                    woodenWholeDigit = 0;
                }
            }
        }

    }

    void okButton(){ //press ok button on pages other than password page
        click.start();
        textGood.setVisibility(View.INVISIBLE); //set last animation to invisible
        textTry.setVisibility(View.INVISIBLE); //set last animation to invisible
        //if okButton is pressed
        if (labelTag == 4) {
            OkButton.setTextColor(0x00000000); //set "OK" to transparent
            responsePlayer.stop();
            if (thisIsCorrect == 1) { //correct answer
                chimes.start(); //for celebration
                textGood.setVisibility(View.VISIBLE); //"Good" animation
                Animation textGoodAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.textgoodanim);
                textGood.startAnimation(textGoodAnimation);
                textGood.setVisibility(View.INVISIBLE); //set it to invisible after animation completes
                ding.start();
                oldScore[0] = (int)Math.floor(currentScore / 100); //"Hundreds" before adding marks
                oldScore[1] = (int)Math.floor(currentScore / 10) - oldScore[0] * 10; //"Tens"
                oldScore[2] = currentScore - oldScore[0] * 100 - oldScore[1] * 10; //"Units"
                if (falseInSubQuest > 3) {falseInSubQuest = 3;} //maximum number of false counted
                currentScore = currentScore + 16 - falseInSubQuest * 4; //add marks. Max:16
                if (questSubcount == 1) { //correct on 2nd subQuestion or 1st attempt
                    // next Question
                    questCount += 1;
                    if (questCount == 2) {questCount = 3;}//no password page
                    questSubcount = 0;
                }
                else {
                    // next subQuestion
                    questSubcount += 1;
                }
                newScore[0] = (int)(currentScore / 100); //"Hundreds" of new score
                newScore[1] = (int)Math.floor(currentScore / 10) - newScore[0] * 10; //"Tens"
                newScore[2] = currentScore - newScore[0] * 100 - newScore[1] * 10; //"Tens"
                maxCount = newScore[2]; //add "Units" to new score first
                currentCount = oldScore[2] * 10; //to avoid missing time interval by cutting into 10 small intervals
                digit = 0;
                Continue = true; //After the timer starts, continue the job
                periodicUpdate = new Runnable () {

                    @Override
                    public void run() {
                        if (Continue == true) {
                            // scheduled event in handler
                            updateLabel();
                            handler.postDelayed(periodicUpdate, 25); //repeat the handler
                        }
                    }
                };
                handler.postDelayed(periodicUpdate, 0); //start the handler

                //self.updateTimer = Timer.scheduledTimer(timeInterval: 0.05, target: self, selector: #selector(ViewController.updateLabel), userInfo: nil, repeats: true)

                //reset variables for next subQuestion
                falseInSubQuest = 0;
                thisIsCorrect = 0;
                woodenWholeLastValue = 1;
                woodenWholeDecNum = -1;
                woodenWholeDigit = 0;
                for (int i = 0; i < 3; i++) {
                    woodenValue[i] = 0.0;
                    woodenNumber[i].setText("");
                }
                if (questCount != pagePassword) { //shining star to attract the user on pages other than password page
                    shiningStar1.setVisibility(View.VISIBLE);
                    Animation starAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.staranim);
                    shiningStar1.startAnimation(starAnimation);
                    shiningStar1.setVisibility(View.INVISIBLE);
                }
                SetText();
            }
            else { //incorrect answer
                click.start();
                if (ansFormat == 1) { //fill in blank format
                    for (int i = 0; i < 3; i++) {
                        woodenValue[i] = 0.0;
                        woodenNumber[i].setText("");
                    }
                    woodenWholeLastValue = 1;
                    woodenWholeDecNum = -1;
                    woodenWholeDigit = 0;
                }
                textTry.setVisibility(View.VISIBLE); //"Try Again" animation
                Animation textTryAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.texttryanim);
                textTry.startAnimation(textTryAnimation);
                textTry.setVisibility(View.INVISIBLE);
            }
        }
    }

    void pressAnswer(){ //press a button on MC format page
        responseView.setImageResource(dataBase.responseView[questCount][questSubcount][labelTag]);
        OkButton.setTextColor(0xFF000000); //set "OK" to black
        if (labelTag == dataBase.correct[questCount][questSubcount]) { //correct answer
            MCButtonColor[labelTag].setBackgroundResource(R.drawable.bluebutton2);
            OkButton.setText("下一題");
            thisIsCorrect = 1;
        }
            else { //incorrect answer
            MCButtonColor[labelTag].setBackgroundResource(R.drawable.redbutton2);
            OkButton.setText("再算一算");
            falseInSubQuest += 1;
            thisIsCorrect = 0;
        }
        responsePlayer = MediaPlayer.create(getApplicationContext(), dataBase.audioFile[questCount][questSubcount][labelTag]);
        responsePlayer.start();
    }

    void SetText() { //set images and buttons for next page
        shiningStar1.setVisibility(View.INVISIBLE);
        shiningStar2.setVisibility(View.INVISIBLE);
        textGood.setVisibility(View.INVISIBLE);
        textTry.setVisibility(View.INVISIBLE);
        ansFormat = dataBase.answerFormat[questCount];
        responseView.setImageResource(R.drawable.nothing);
        if (questCount == pagePassword) {
            responseView.setImageResource(dataBase.responseView[pagePassword][0][0]);
            responsePlayer = MediaPlayer.create(getApplicationContext(), dataBase.audioFile[questCount][0][0]);
            responsePlayer.start();
        }
        if (questCount == totalQuest) { //conclusion page
            responseView.setImageResource(dataBase.responseView[totalQuest][0][0]);
            responsePlayer = MediaPlayer.create(getApplicationContext(), dataBase.audioFile[questCount][0][0]);
            responsePlayer.start();
        }
        questionView.setImageResource(dataBase.questionView[questCount][questSubcount]);
        if (ansFormat == 0) { //MC format
            //not display the sentence that tells user to press woodboard first
            textID.setText("總分=" + String.valueOf(32*(totalQuest - 1)) + "        " + "ID=" + String.valueOf(ID));
            layoutMC1.setVisibility(View.VISIBLE);
            layoutMC2.setVisibility(View.VISIBLE);
            layoutWooden.setVisibility(View.GONE);
            layoutSquare.setVisibility(View.GONE);
            for (int i = 0; i < 4; i++) { //MC buttons default color: orange
                MCButtonColor[i].setBackgroundResource(R.drawable.orangebutton2);
                buttonsMC[i].setImageResource(dataBase.answerView[questCount][questSubcount][i]);
            }
            OkButton.setTextColor(0x00FFFFFF); //set "OK" to transparent
        } else { //fill in blank format
            //tell user to press the woodboard first
            textID.setText("請先按一下木板才按數字。       ID=" + String.valueOf(ID));
            woodenWholeLastValue = 1;
            woodenWholeDecNum = -1;
            woodenWholeDigit = 0;
            layoutMC1.setVisibility(View.GONE);
            layoutMC2.setVisibility(View.GONE);
            layoutWooden.setVisibility(View.VISIBLE);
            layoutSquare.setVisibility(View.VISIBLE);
            fillInBlank.setImageResource(dataBase.answerView[questCount][questSubcount][0]);
            OkButton.setTextColor(0xFF000000); //set "OK" to black
            OkButton.setText("確定");
            if (dataBase.nonFraction[questCount] == 1) { //the answer is not a fraction, it is a decimal
                decimalView.setText(".");
                layoutFraction.setVisibility(View.INVISIBLE); //set Numerator and denominator to transparent
            }
            else { //the answer is a fraction
                decimalView.setText("");
                layoutFraction.setVisibility(View.VISIBLE);
            }
        }
    }

    void updateLabel() { //adding marks animation
        currentCount += 5; //currentCount times 10 to cut the time interval
        if (currentCount > 95) {currentCount = 0;} //value added up to 10 then start from 0
        score[2 - digit].setText(String.valueOf((int)(currentCount / 10)));
        if ((currentCount % 10) == 0) {click.start();}
        if ((int)(currentCount / 10) == maxCount) { //animation of this place completes
            switch (digit) {
                case 0: digit = 1; //animation moves from digit 0 to digit 1
                        currentCount = oldScore[1] * 10;
                        maxCount = newScore[1];
                        break;
                case 1: digit = 2; //animation moves from digit 1 to digit 2
                        currentCount = oldScore[0] * 10;
                        maxCount = newScore[0];
                        break;
                case 2: Continue = false; //three digits complete, stop the handler
                        break;
                default:digit = 2;
                        break;
            }
        }
    }
}
