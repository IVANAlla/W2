//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
//import java.util.*;

//Создайте консольное приложение "Строковый калькулятор".
// Приложение должно читать из консоли введенные пользователем строки, числа, арифметические операции проводимые между ними
// и выводить в консоль результат их выполнения.
//
//Требования:
//Калькулятор умеет выполнять операции сложения строк, вычитания строки из строки,
// умножения строки на число и деления строки на число: "a" + "b", "a" - "b", "a" * b, "a" / b.
// Данные передаются в одну строку(смотрите пример)!
// Решения, в которых каждая строка, число и арифмитеческая операция передаются с новой строки считаются неверными.
//Значения строк передаваемых в выражении выделяются двойными кавычками.
//Результатом сложения двух строк, является строка состоящая из переданных.
//Результатом деления строки на число n, является строка в n раз короче исходной (смотрите пример).
//Результатом умножения строки на число n, является строка, в которой переданная строка повторяется ровно n раз.
//Результатом вычитания строки из строки, является строка,
// в которой удалена переданная подстрока или сама исходная строка, если в нее нет вхождения вычитаемой строки (смотрите пример).
//Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. И строки длинной не более 10 символов. Если строка, полученная в результате работы приложения длинее 40 симовлов, то в выводе после 40 символа должны стоять три точки (...)
//Калькулятор умеет работать только с целыми числами.
//Первым аргументом выражения, подаваемого на вход, должна быть строка, при вводе пользователем выражения вроде 3 + "hello",
// калькулятор должен выбросить исключение и прекратить свою работу.
//При вводе пользователем неподходящих чисел, строк или неподдерживаемых операций (например, деление строки на строку)
// приложение выбрасывает исключение и завершает свою работу.
//При вводе пользователем выражения, не соответствующего одной из вышеописанных арифметических операций,
// приложение выбрасывает исключение и завершает свою работу.
//Пример работы программы:
//Input:
//"100" + "500"
//
//Output:
//"100500"
//
//Input:
//"Hi World!" - "World!"
//
//Output:
//"Hi "
//
//Input:
//"Bye-bye!" - "World!"
//
//Output:
//"Bye-bye!"
//
//Input:
//"Java" * 5
//
//Output:
//"JavaJavaJavaJavaJava"
//
//Input:
//"Example!!!" / 3
//
//Output:
//"Exa"
//
//Принципы оценки работы:
//Обратите внимание на принципы ООП, постарайтесь разбить программу на логические классы. Решения, в которых весь код программы находится в одном классе будут низко оценены. Продемонстрируйте своё умение в работе с разными синтаксическими конструкциями, не забудьте про исключительные ситуации, при которых выполнение программы невозможно из-за некорректных входных данных.
public class Main
{
    public static void main(String[] args) throws Exception {
      //  System.out.println("Hello World");
        while(true){ Scanner ip = new Scanner(System.in);
            System.out.println("Intput:");
            String input=ip.nextLine() ;

            String tests=" " ; char[] znacs = new char[40];char znac = '+';

            for (int i = 1; i < input.length(); i++) {
                znacs[i] = input.charAt(i);
                if (znacs[i] == '+') {
                    znac = '+';
                    tests = "\\+";
                }
                if (znacs[i] == '-') {
                    znac = '-';
                    tests = "-";
                }
                if (znacs[i] == '*') {
                    znac = '*';
                    tests = "\\*";
                }
                if (znacs[i] == '/') {
                    znac = '/';
                    tests = "/";
                }
            }

            String number1 = " ";
            String number2 = " ";
          //  String result ="";
            String[] numbers = input.split(tests);

            try {
                if (numbers.length == 2 ) {
                    number1 = numbers[0];
                    number2 = numbers[1];

                }
            }catch (Exception e) {

                throw new Exception (); //System.out.println("throws Exception");throw new Exception();
            }
            if (number1.length()>12) throw new Exception();
            if (number2.length()>12) throw new Exception();
            if (znac == '*' || znac == '/') {
            if(Integer.parseInt(number2)>=11) throw new Exception();}
            if (znac == '*' || znac == '/') {
                if (number2.contains("\"")) throw new Exception();
            }
            if (!(number1.contains("\"")) ) {
                throw new Exception();
            }
            if ((number1.contains("\"")) ) { if (number1.indexOf('"')==number1.lastIndexOf('"') )
                throw new Exception();
            }

            if (znac == '+' || znac == '-') {
                if (!(number2.contains("\""))) throw new Exception();
            }

            if (znac =='+') {
                Plus plus = new Plus(number1,number2);

                printInQuotes (plus.displayInfo());
            }
            if ( znac =='*') {Proiz proiz=new Proiz(number1,number2);
                printInQuotes (proiz.displayInfo());
            }


            if (znac == '-') {
                Minus minus = new Minus(number1,number2);
                printInQuotes (minus.displayInfo());

            }

            if(znac == '/'){
                Del del = new Del(number1,number2);

                printInQuotes (del.displayInfo());
            }
        }
    }
    static void printInQuotes(String text){
        System.out.println("Output:");
        System.out.println("\""+text.replace("\"", "")+"\"");
    }}
abstract class Znak {
    String number1;
    String number2;
    public Znak(String number1,String number2){

        this.number1=number1;
        this.number2=number2;
    }

    public abstract String displayInfo();}
class Plus extends Znak{

    Plus( String number1,String number2){
        super(number1,number2);
    }
    public String displayInfo(){
        return number1.concat( number2 );
    } }

class Proiz extends Znak{
    Proiz( String number1,String number2){
        super(number1,number2);
    }
    public String displayInfo(){
// int number=Integer.parseInt(number2);
//result= (number1.repeat(Integer.parseInt(number2)).replace("\"",""));
        if( number1.replace("\"","").repeat(Integer.parseInt(number2)).replace("\"","").length()<=40)
            return number1.repeat(Integer.parseInt(number2)).replace("\"","");//.replace("\"", "").replace("\"", "")
        else
            return (number1.repeat(Integer.parseInt(number2)).replace("\"","").substring(0,40)+"...");
    } }
class Del extends Znak{

    Del( String number1,String number2){
        super(number1,number2);
    }
    public String displayInfo(){
// int newLen = number1.length()/Integer.parseInt(number2);
//result = number1.substring(0,number1.length()/Integer.parseInt(number2));
        return number1.replace("\"","").substring(0,number1.replace("\"","").length()/Integer.parseInt(number2));


    } }
class Minus extends Znak{

    Minus( String number1,String number2){
        super(number1,number2);
    }
    public String displayInfo(){
        int index=0;   index = number1.replace("\"","").indexOf(number2.replace("\"",""));


        String    result=number1.replace("\"", "").substring(0, index) +number1.replace("\"", "").substring(( index+number2.replace("\"", "").length()));
        return result;
    } }