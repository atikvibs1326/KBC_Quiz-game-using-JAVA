import java.io.*;//package included to display KBC
import java.util.Random;
class KBC//class name
{
 static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//input statement
 static Random r=new Random();//input statement
 static int stage,amount,life,aud=0,phn=0,expt=0,ddip=0,ddip1=0,correct,in,fin,c;//variable assigned to integer
 static String s1,opt;//variable assigned to string
 static int a[]={5000,10000,20000,40000,80000,160000,320000,640000,1250000,2500000,5000000,10000000,50000000};/*storage of
 amount into array*/;
 static String s[]={"1 : Audience poll","2 : Phone a friend","3 : Expert Advice","4 : Double dip"};/*lifelines stored in
 string*/;
 public static void main(String args[])throws IOException
 {
     display();//will call the method display
     database();//will call the method database
    }
    static void display()throws IOException
    {
        int i,j;//variables assigned
        System.out.print("Welcome to Kaun Banega Crorepati");
        System.out.print("\nYou'll have to answer 13 questions to win 5 crore ruppees\n");
        for(i=1;i<=13;i++)//loop runs 13 times since there are 13 cash amounts
        {
            System.out.print("\n"+i+" ---> Rs. "+a[i-1]);//a[i-1] includes the cash amount stored in array
                    }
        System.out.print("\n");
        stageset();
        System.out.print("\fIn addition to this, you'll have 4 lifelines to assist you\n\n");
        System.out.print(s[0]+" : Will help you to take audience's opinion\n");
        System.out.print(s[1]+" : Will enable you to call your friend for the answer\n");
        System.out.print(s[2]+" : Ask the experts for their advice\n");
        System.out.print(s[3]+" : Will allow you to give two answers for the same question\n");
        System.out.print("\nWarning : If you use double dip, you'll not be able to quit the game or use another lifeline");
        controls();//calls from the method controls
    }
    static void stageset()throws IOException
    {
        String c;
        System.out.print("\nPlease set a stage (Enter question number) : ");
        stage=Integer.parseInt(br.readLine());
        if(stage>=1 && stage<=13)
        {
            System.out.print("\nYou have selected : "+stage+" <> Rs. "+a[stage-1]);
            System.out.print("\n\nAre you sure (Y/N) : ");
            c=br.readLine();
            if(!(c.substring(0).equalsIgnoreCase("Y")))
            stageset();
        }
        else
        {
            System.out.print("\nInvalid input. Please enter again.\n");
            stageset();
        }
    }
    static void controls()throws IOException
    {
        System.out.print("\n\nEnter choices as A B C D");
        System.out.print("\nEnter 'L' to choose a life-line");
        System.out.print("\nEnter 'Q' to quit");
        System.out.print("\n\nEnter any key to clear screen and continue : ");
        s1=br.readLine();
        System.out.print("\f");
    }
    static void play()throws IOException
    {
        System.out.print("\n\nEnter your choice : ");//to enter the choice
        opt=br.readLine();
        if(opt.substring(0,1).equalsIgnoreCase("A"))
        c=1;
        if(opt.substring(0,1).equalsIgnoreCase("B"))
        c=2;
        if(opt.substring(0,1).equalsIgnoreCase("C"))
        c=3;
        if(opt.substring(0,1).equalsIgnoreCase("D"))
        c=4;
        if(opt.substring(0,1).equalsIgnoreCase("L"))
        {
            lifeline();
            if(ddip1==0)
            play();
            ddip1=0;
        }
        if(opt.substring(0,1).equalsIgnoreCase("Q"))
        quit();
    }
    static void lifeline()throws IOException
    {
        int i;
        System.out.print("\nYou have the following lifelines left : ");
        for(i=0;i<=3;i++)
        System.out.print(s[i]+"  ");
        System.out.print("\n\nWhich one would you like to use (Enter number) : ");
        life=Integer.parseInt(br.readLine());//to choose lifelines
        switch(life)//switch statement
        {
            case 1://first case for audience poll
            audience();
            break;
            case 2://second case for phone a friend
            phone();
            break;
            case 3://third case for experts advice
            expert();
            break;
            case 4://fourth case for double dip
            dip();
            break;
            default:
            System.out.print("\nThis life line is not available");
        }
    }
    static void database()throws IOException
    {
        int cont=1;
        System.out.print("Stage : "+cont+" <> "+a[0]+"\n\n");//Here comes the QUESTIONS
        System.out.print("The internatinal literacy day is observed on : ");
        System.out.print("\n\nA: feb 6\t\tB: Sept 8\nC: Dec21\t\tD: Jan 1");
        correct=2;
        play();
        if(correct==c)
        {
            in=a[0];
            System.out.print("\nWell done. Correct answer.");
            if(stage==1)//stage is selected by the user
            {
                fin=in;//cash is being stored in the the variable fin
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is B");
            end();//calls the method end
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[1]+"\n\n");
        System.out.print("The language of lakshwadeep is : ");
        System.out.print("\n\nA: Marathi\t\tB: Tamil\nC: Malyalyam\t\tD: Hindi");
        correct=3;
        play();
        if(correct==c)
        {
            in=a[1];
            System.out.print("\nWell done. Correct answer.");
            if(stage==2)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is C");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[2]+"\n\n");
        System.out.print("Bahubali festival is related to : ");
        System.out.print("\n\nA: Shekism\t\tB: buddhism\nC: Islam\t\tD:Jainism");
        correct=4;
        play();
        if(correct==c)
        {
            in=a[2];
            System.out.print("\nWell done. Correct answer.");
            if(stage==3)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is D");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[3]+"\n\n");
        System.out.print("World health day is on : ");
        System.out.print("\n\nA: june3\t\tB: april 7 \nC: april 12\t\tD: dec 1");
        correct=2;
        play();
        if(correct==c)
        {
            in=a[3];
            System.out.print("\nWell done. Correct answer.");
            if(stage==4)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is B");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[4]+"\n\n");
        System.out.print("Who is : ");
        System.out.print("\n\nA: Smt. Pratibha Devisingh Patil\t\tB: Isabel Mart�nez de Per�n\nC: Mary McAleese\t\tD: Valeria Ciavatta");
        correct=1;
        play();
        if(correct==c)
        {
            in=a[4];
            System.out.print("\nWell done. Correct answer.");
            if(stage==5)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is A: Smt. Pratibha Devisingh Patil");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[5]+"\n\n");
        System.out.print("Who owns the fast food joints KFC and Pizza Hut ? : ");
        System.out.print("\n\nA: McFood\t\tB: Yum! Restaurants\nC: DesPlaines Illinois\t\tD: Richard and Maurice");
        correct=2;
        play();
        if(correct==c)
        {
            in=a[5];
            System.out.print("\nWell done. Correct answer.");
            if(stage==6)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is B: Yum! Restaurants");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[6]+"\n\n");
        System.out.print("Where was the first oil well struck in the world? : ");
        System.out.print("\n\nA: Kuwait\t\tB: USA\nC: Saudi Arabia\t\tD: Australia");
        correct=2;
        play();
        if(correct==c)
        {
            in=a[6];
            System.out.print("\nWell done. Correct answer.");
            if(stage==7)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is B: USA");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[7]+"\n\n");
        System.out.print("Located in India it is Asia's largest residential university. Name it...? : ");
        System.out.print("\n\nA: Banaras Hindu University\t\tB: The Utkal University\nC: Jawaharlal Nehru University\t\tD: Anna University");
        correct=1;
        play();
        if(correct==c)
        {
            in=a[7];
            System.out.print("\nWell done. Correct answer.");
            if(stage==8)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is A: Banaras Hindu University");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[8]+"\n\n");
        System.out.print("Who among the following is NOT associated with billiards in India? : ");
        System.out.print("\n\nA: Subash Agrawal\t\tB: Ashok Shandilya\nC: Manoj Kothari\t\tD: Mihir Sen");
        correct=4;
        play();
        if(correct==c)
        {
            in=a[8];
            System.out.print("\nWell done. Correct answer.");
            if(stage==9)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is D: Mihir Sen");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[9]+"\n\n");
        System.out.print("Who among the following was NOT the Chief Minister of Madras state or the Tamil Nadu? : ");
        System.out.print("\n\nA: C.Rajagopalachari\t\tB: C.Annadurai\nC: M.G.Ramachandran\t\tD: Poti Sriramulu");
        correct=4;
        play();
        if(correct==c)
        {
            in=a[9];
            System.out.print("\nWell done. Correct answer.");
            if(stage==10)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is D: Poti Sriramulu");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[10]+"\n\n");
        System.out.print("Who wrote the Novel 'Pather Dabi' in Bengali? : ");
        System.out.print("\n\nA: Kazi Nazrul Islam\t\tB: Bankim Chandra\nC: Saratchandra Chattopadhay\t\tD: Rabindranath Tagore");
        correct=3;
        play();
        if(correct==c)
        {
            in=a[10];
            System.out.print("\nWell done. Correct answer.");
            if(stage==11)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is C: Saratchandra Chattopadhay");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[11]+"\n\n");
        System.out.print("Which of the following is a popular form of Buddhism in Japan? : ");
        System.out.print("\n\nA: Zen\t\tB: Pikachu\nC: Totoro\t\tD: Matsushita");
        correct=1;
        play();
        if(correct==c)
        {
            in=a[11];
            System.out.print("\nWell done. Correct answer.");
            if(stage==12)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is A: Zen");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\fStage : "+cont+" <> "+a[12]+"\n\n");
        System.out.print("What was the capital of Panchala? : ");
        System.out.print("\n\nA: Dwaraka\t\tB: Matsya\nC: Kamapilya\t\tD: Magadha");
        correct=3;
        play();
        if(correct==c)
        {
            in=a[12];
            System.out.print("\nWell done. Correct answer.");
            if(stage==13)
            {
                fin=in;
                System.out.print("\n\nCongratulations, you have completed your desired stage succesfully");
            }
        }
        else
        {
            System.out.print("\nSorry, but this is the wrong answer");
            System.out.print("\n\nCorrect answer is C: Kamapilya");
            end();
        }
        System.out.print("\n\nEnter any key to continue : ");
        s1=br.readLine();
        cont++;
        System.out.print("\f");
        for(int i=1;i<=3;i++)
        {
            System.out.print("Many ");
        }
        System.out.print("Congratulations to you.\n\nYou have completed this challenge");
        quit();
    }
    static void audience()throws IOException
    {
        aud++;
        int a[]=new int[3];// three numbers are stored in an array
        int s1=0,i,j,c;
        s[0]="";
        for(i=0;i<=2;i++)
        {
            c=r.nextInt(15);//randomly any three numbers are selected
            a[i]=c;
        }
        s1=100-(a[0]+a[1]+a[2]);//s1 is equal to difference between 100 and the sum of the 3 numbers selected randomly
        System.out.print("\nAwaiting reply ");
        for(i=1;i<=3;i++)
        {
            System.out.print(".");
                   }
        System.out.print("\n\n");
        if(correct==1)
        {
            System.out.print("\nA : "+s1+" %");
            System.out.print("\nB : "+a[0]+" %");
            System.out.print("\nC : "+a[1]+" %");
            System.out.print("\nD : "+a[2]+" %");
        }
        if(correct==2)
        {
            System.out.print("\nA : "+a[0]+" %");
            System.out.print("\nB : "+s1+" %");
            System.out.print("\nC : "+a[1]+" %");
            System.out.print("\nD : "+a[2]+" %");
        }
        if(correct==3)
        {
            System.out.print("\nA : "+a[1]+" %");
            System.out.print("\nB : "+a[0]+" %");
            System.out.print("\nC : "+s1+" %");
            System.out.print("\nD : "+a[2]+" %");
        }
        if(correct==4)
        {
            System.out.print("\nA : "+a[2]+" %");
            System.out.print("\nB : "+a[0]+" %");
            System.out.print("\nC : "+a[1]+" %");
            System.out.print("\nD : "+s1+" %");
        }
    }
    static void phone()
    {
        phn++;
        int c=r.nextInt(5);//any 5 numbers are selected randomly to c
        System.out.print("\n");
        s[1]="";
        if(c==1 || c==3 || c==5 || c==4)
        {
            if(correct==1)
            System.out.print("Friend says its 'A'");
            if(correct==2)
            System.out.print("Friend says its 'B'");     
            if(correct==3)
            System.out.print("Friend says its 'C'");
            if(correct==4)
            System.out.print("Friend says its 'D'");
        }
        else
        System.out.print("Friend has no idea");
    }
    static void expert()
    {
        expt++;
        int c=r.nextInt(5);//any 5 numbers are selected randomly to c
        System.out.print("\n");
        s[2]="";
        if(c==1 || c==3 || c==5 || c==4)
        {
            if(correct==1)
            System.out.print("Expert thinks it to be 'A'");
            if(correct==2)
            System.out.print("Expert thinks it to be 'B'");     
            if(correct==3)
            System.out.print("Expert thinks it to be 'C'");
            if(correct==4)
            System.out.print("Expert thinks it to be 'D'");
        }
        else
        System.out.print("Expert has no idea");
    }
    static void dip()throws IOException
    {
        s[3]="";
        ddip1=1;//initialization of ddip1
        ddip++;
        System.out.print("\nFirst choice : ");
        play();
        if(correct==c)
        {
           System.out.print("\nCorrect answer");
        }
        else
        {
            System.out.print("\nWrong answer\n\nSecond choice : ");
            play();
        }
    }
    static void quit()
    {
        fin=in;//display the original amount
        end();
    }
    static void end()
    {
        System.out.print("\n\nYou have won Rs. "+fin);
        System.out.print("\n\nThank you for participating in KBC version 1.0");
        System.out.print("\n\nWish you all the best\nTake care\nSee you again.");
        System.exit(0);
    }
}
           
