package bit2bytes.challenge;

import java.util.*;

public class Mock002 {

    static Map<Character, String> flames = new HashMap<>();
    static List<Character> flamesList = new ArrayList<>();
    static String firstName = "";
    static String secondName = "";

    static {
        flames.put('F', "Friend");
        flames.put('L', "Love");
        flames.put('A', "Adore");
        flames.put('M', "Marriage");
        flames.put('E', "Enemy");
        flames.put('S', "Sibling");
        flames.put('O', "Unknown");
        flamesList.add('F');
        flamesList.add('L');
        flamesList.add('A');
        flamesList.add('M');
        flamesList.add('E');
        flamesList.add('S');
    }

    static final void methodImpl() {
        if((firstName != null) && (!firstName.equals("")) && (secondName != null) && (!secondName.equals(""))){
            firstName = firstName.trim();
            secondName = secondName.trim();
            firstName = firstName.toUpperCase();
            secondName = secondName.toUpperCase();
            Map<Character, Integer> firstNameMap = new HashMap();
            Map<Character, Integer> secondNameMap = new HashMap();
            Map<Character, Integer> characterMap = new HashMap();
            for(int i=0;i<firstName.length();i++) {
                if (firstName.charAt(i) != ' ') {
                    if (firstNameMap.containsKey(firstName.charAt(i))) {
                        int count = firstNameMap.get(firstName.charAt(i));
                        firstNameMap.put(firstName.charAt(i), count + 1);
                    } else {
                        firstNameMap.put(firstName.charAt(i), 1);
                    }
                }
            }
            for(int i=0;i<secondName.length();i++) {
                if (secondName.charAt(i) != ' ') {
                    if (secondNameMap.containsKey(secondName.charAt(i))) {
                        int count = secondNameMap.get(secondName.charAt(i));
                        secondNameMap.put(secondName.charAt(i), count + 1);
                    } else {
                        secondNameMap.put(secondName.charAt(i), 1);
                    }
                }
            }

            Set firstCharSet = firstNameMap.keySet();
            Iterator it = firstCharSet.iterator();
            while(it.hasNext()) {
                Character character = (Character) it.next();
                int firstCount = firstNameMap.get(character);
                int finalCount = firstCount;
                if(secondNameMap.containsKey(character)) {
                    int secCount = secondNameMap.get(character);
                    if(firstCount > secCount){
                        finalCount = firstCount-secCount;
                    } else
                        finalCount = secCount-firstCount;
                }
                characterMap.put(character,finalCount);
            }

            Set secondCharSet = secondNameMap.keySet();
            Iterator secCharIt = secondCharSet.iterator();
            while(secCharIt.hasNext()) {
                Character character = (Character) secCharIt.next();
                if(!characterMap.containsKey(character)) {
                    int secCount = secondNameMap.get(character);
                    characterMap.put(character,secCount);
                }
            }
            int finalCount = 0;
            Set charSet = characterMap.keySet();
            Iterator charSetIt = charSet.iterator();
            while(charSetIt.hasNext()) {
                Character character = (Character) charSetIt.next();
                int secCount = characterMap.get(character);
                finalCount = finalCount+secCount;
            }

            String message = "Unknown";
            if(finalCount > 0) {
                int settlementCount = 1;
                while (flamesList.size() > 1) {
                    List<Character> localList = new ArrayList<>();
                    int loopCount = finalCount / flamesList.size();
                    loopCount = loopCount + 1;
                    for (int i = 0; i < loopCount; i++) {
                        localList.addAll(flamesList);
                    }
                    Character character = localList.get(finalCount - settlementCount);
                    settlementCount = flamesList.size() - (flamesList.indexOf(character) + 1);
                    settlementCount = settlementCount + 1;
                    flamesList.remove(character);
                }
                message = flames.get(flamesList.get(0));
            }
                System.out.print(finalCount + " " );
                System.out.print(message);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // input as per specification.
        System.out.println("Enter first name");
        firstName = scanner.nextLine();

        System.out.println("Enter second name");
        secondName = scanner.nextLine();

        methodImpl();
        scanner.close();
    }
}
