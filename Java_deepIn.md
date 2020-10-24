1. Hello World Program

   Any Java program needs to start with a class

   public : define the class can be accessed

   psvm : main method

   static : 被宣告為`static`的成員，不會讓個別object擁有，而是屬於class

   ```java
   public class HelloWorld {
   	public static void main(String[] args) {
   		Sysyem.out.println("Hello World");
   	}
   }
   ```

2. Variables

3. Arrays

   ```java
   public class HelloWorld {
   	public static void main(String[] args) {
   		int[] primeNumbers = {2, 3, 5, 7, 11, 13};
           System.out.println(primeNumbers); // memory address of the array
           System.out.println(primeNumbers[2]); // 5 
           System.out.println(primeNumbers.length); // 6
   	}
   }
   ```

4. List

   - can do more things than arrays

   ```java
   import java.util.*; // import all the items in the util library
   public class HelloWorld {
       public static void main(String[] args) {
           List list = new ArrayList();
           // add items to list
           list.add(2); // [2]
   		list.add(3); // [2,3]
           list.add(5); // [2,3,5]
           // remove elements
           list.remove(1); // [2,5], 3 is removed
           // obtain the element with the index
           System.out.println(list.get(1)); // 5
           // Convert the list to string 
           System.out.println(list.toString()); // [2,5] 
       }
   }
   ```

5. HashMap

   ```java
   import java.util.*;
   public class HelloWorld {
       public static void main(String[] args) {
           Map map = new HashMap();
           // maps the Father (index) to the value Rob
           // Father is key, Rob is value 
           // similar to the map in C++
           map.put("Father", "Rob");
           map.put("Mother", "Kirsten");
           //map.remove("Mother"); // mother is remove
           System.out.println(map.get("Father")); // Rob
           System.out.println(map.toString()); // [mother=Kirsten, father=Rob]
           
       }
   }
   ```

6. If Statements

   ```java
   public class HelloWorld {
   	public static void main(String[] args) {
           if (2 > 1) {
               System.out.println("2 is greater than 1"); // It will be printed
           }
       }
   }
   ```

   ```java
   public class HelloWorld {
   	public static void main(String[] args) {
   		int age = 18;
   		if (age == 18) {
   			System.out.println("User is 18"); // Print this
   		} else if (age < 18) {
               System.out.println("User is under 18");
           } else {
               System.out.println("User is over 18");
           }
   	}
   }
   ```

   ```java
   // Task : Enter two variables and compare their values
   import java.util.scanner; // input
   public class HelloWorld {
       public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);
           int num1 = scanner.nextInt();
           int num2 = scanner.nextInt();
           if (num1 == num2) {
               System.out.println("num1 equals to num2");
           } else if (num1 > num2) {
               System.out.println("num1 is greater than num2");
           } else {
               System.out.println("num1 is less than num2");
           }
       }
   }
   ```

7. Loop

   ```java
   // print numbers from 1 to 10
   public class HelloWorld {
   	public static void main(String[] args) {
   		int x = 1;
   		while(x <= 10) {
               System.out.println(x);  // 1 2 3 4 5 6 7 8 9 10
               x++; // prevent infinite loop
           }
   	}
   }
   ```

   ```java
   // print the even numbers from 1 to 10
   public class HelloWorld {
   	public static void main(String[] args) {
   		int x = 1;
   		while(x <= 10) {
               if (x %2 == 0) {
                   System.out.println(x);  // 2 4 6 8 10
               }
               x++; // prevent infinite loop
           }
   	}
   }
   ```

   ```java
   // for loop
   public class HelloWorld {
   	public static void main(String[] args) {
   			for (int i = 1; i <= 5; i++) {
                   System.out.println(i * 2); // 2 4 6 8 10
               }
           }
   	}
   }
   ```

   ```java
   // easier challenge
   // display the 10 multiples of 3
   public class HelloWorld {
   	public static void main(String[] args) {
   			int i = 0;
           	int num = 1;
           	while(i < 10) {
                   if (num % 3 == 0) {
                       System.out.println(num);
                       i++;
                   } 
                   num++;
               }
           }
   	}
   }
   ```

   ```java
   // Looping throught the contents of an array
   public class HelloWorld {
       public static void main(String[] args) {
           String[] familyMembers = {"Rob", "Kirsten", "Tommy"};
           // foreach loop
           for (String name : familyMembers) {
               System.out.println(name);
           }
           // for loop
           for (int i = 0; i < familyMembers.length; i++) {
               System.out.println(familyMembers[i]);
           }
       }
   }
   ```

   ```java
   // Looping throught the contents of an array
   public class HelloWorld {
       public static void main(String[] args) {
           //List familyMembers = new ArrayList();
           List<String> familyMembers = new ArrayList<String>();
           
           familyMembers.add("Rob");
           familyMembers.add("Kirsten");
           familyMembers.add("Tommy");
           familyMembers.add("Ralphie");
           
           // foreach loop
           for (String name : familyMembers) {
               System.out.println(name);
           }
       }
   }
   ```

8. Class and Objects

   ```java
   public class HelloWorld {
   	public static void main(String[] args) {
           
           class User {
               int score;
               public boolean hasWon() {
                   if (score >= 100) {
                       return true;
                   }
                   return false;
               }
           }
           
           User bob = new User();
           bob.score = 10;
           System.out.println(bob.score); // 10
           System.out.println(bob.hasWon()); // false
       }
   }
   ```

   







