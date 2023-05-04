package Alekcs;
public class Line {
    private String str;

    public Line() {
        str = "adad rfeg regreg ergr greg trhe";
    }
    public Line(String arg)
    {
        str = arg;
    }

    public void Remove() {
        System.out.println();
        System.out.println("e) Удалить из строки каждое третье слов:");
        System.out.println(str);
        String str1 = "";
        String[] words = str.split(" ");

        for (int i = 0; i < words.length; i++) {
            if ((i + 1) % 3 != 0) {
                str1 = str1 + words[i] + " ";
            }
            if (str1 == "") {
                str1 = "В строке нет слов";
            }
        }
        System.out.println(str1);
    }
    public String getLine()
    {
        return this.str;
    }
}
