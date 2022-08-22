import java.util.Arrays;

public class Hashing {
    String[] HashTableStringLinear;
    Integer[] HashTableIntegerLinear;
    String[] HashTableStringDouble;
    Integer[] HashTableIntegerDouble;
    int arraySize;

    Hashing(int size) {
        arraySize = size;
        //instantiating the arrays that represent hashtables
        HashTableStringLinear = new String[size];
        HashTableIntegerLinear = new Integer[size];
        Arrays.fill(HashTableStringLinear, "-1");
        Arrays.fill(HashTableIntegerLinear, -1);
        HashTableStringDouble = new String[size];
        HashTableIntegerDouble = new Integer[size];
        Arrays.fill(HashTableStringDouble, "-1");
        Arrays.fill(HashTableIntegerDouble, -1);
    }

    public void insertToHashTable(String[] inputElements, String[] HashTable) { 
      //inserting string values to the hashtable and solving collisions using linear probing

        for (int c = 0; c < inputElements.length; c++) {

            int hash =  inputElements[c].hashCode();
            //String hashS = Integer.toString(hash);
            //hashS = hashS.substring(0,3);
            //int hashValue = Integer.valueOf(hashS);
            int hashValue = hash;

            hashValue = hashValue % arraySize;

            if (hashValue > arraySize){

                hashValue = hashValue % arraySize;
            }

            if (hashValue < 0){

                hashValue = Math.abs(hashValue);
            }

            System.out.println("HashTable Index/Hash Value: " + hashValue + " for key " + inputElements[c]);

            // Goes through element until it reaches empty space

            while (HashTable[hashValue] != "-1") {

                ++hashValue;

                System.out.println("A Hashing Collision Occurred! Inputting " + inputElements[c] + " into index " + hashValue);

                //to go back to index 0
                hashValue %= arraySize;

            }

            HashTableStringLinear[hashValue] = inputElements[c];
        }
    }

    public void insertToHashTable(Integer[] inputElements, Integer[] HashTable) {
    //inserting integer values to the hashtable and solving collisions using linear probing
        for (int c = 0; c < inputElements.length; c++) {

            int hashValue = inputElements[c] % arraySize;

            if (hashValue > arraySize){

                hashValue = hashValue % arraySize;
            }

            System.out.println("HashTable Index/Hash Value: " + hashValue + " for key " + inputElements[c]);

            // Goes through element until it reaches empty space

            while (HashTable[hashValue] != -1) {

                ++hashValue;

                System.out.println("A Hashing Collision Occurred! Inputting " + inputElements[c] + " into index " + hashValue);

                //to go back to index 0
                hashValue %= arraySize;

            }
            HashTableIntegerLinear[hashValue] = inputElements[c];
        }
    }

    public void insertDoubleHashInt(Integer[] inputElements, Integer[] HashTable) {
      //inserting integer values to the hashtable and solving collisions using double hashing

        for (int c = 0; c < inputElements.length; c++) {

            int hashValue = inputElements[c] % arraySize;

            if (hashValue > arraySize){

                hashValue = hashValue % arraySize;
            }

            System.out.println("HashTable Index/Hash Value: " + hashValue + " for key " + inputElements[c]);

            // performs double hashing

            while (HashTable[hashValue] != -1) {

                int steps = 7 - (hashValue % 7);

                hashValue = hashValue + steps;

                System.out.println("A Hashing Collision Occurred! Inputting " + inputElements[c] + " into index " + hashValue);

                //to go back to index 0
                hashValue %= arraySize;

            }

            HashTableIntegerDouble[hashValue] = inputElements[c];
        }
    }


    public void insertDoubleHashStr(String[] inputElements, String[] HashTable) {
      //inserting string values to the hashtable and solving collisions using double hashing

        for (int c = 0; c < inputElements.length; c++) {

            int hash =  inputElements[c].hashCode();
            //String hashS = Integer.toString(hash);
            //hashS = hashS.substring(0,3);
            //int hashValue = Integer.valueOf(hashS);
            int hashValue = hash;
            hashValue = hashValue % arraySize;

            if (hashValue > arraySize){

                hashValue = hashValue % arraySize;
            }

            if (hashValue < 0){

                hashValue = Math.abs(hashValue);
            }
            System.out.println("HashTable Index/Hash Value: " + hashValue + " for key " + inputElements[c]);

            // performs double hashing

            while (HashTable[hashValue] != "-1") {


                int steps = 5 - (hashValue % 5); 

                hashValue = hashValue + steps;

                System.out.println("A Hashing Collision Occurred! Inputting " + inputElements[c] + " into index " + hashValue);

                //to go back to index 0
                hashValue %= arraySize;

            }

            HashTableStringDouble[hashValue] = inputElements[c];

        }
    }


    public int SearchKey(String key, String[] HashTable1) {
      //to retrieve the position of string keys in the string hashtable 

        // calculating the keys initial hash value or key
        int hash =  key.hashCode();
        //String hashS = Integer.toString(hash);
        //hashS = hashS.substring(0,3);
        //int HashArrayIndex = Integer.valueOf(hashS);

        int HashArrayIndex = hash;

        HashArrayIndex = HashArrayIndex % arraySize;


        // calculating the keys initial hash value or key

        if (HashArrayIndex > arraySize){

            HashArrayIndex = HashArrayIndex % arraySize;
        }

        while (HashTable1[HashArrayIndex] != "-1") {

            if (HashTable1[HashArrayIndex] == key) {

                //when we find the key matches succesfully, return it
                System.out.println("Key: " + key+ " is at index: " + HashArrayIndex);
                return 0;

            }


            //search and compare at the next index of the hash table
            HashArrayIndex++;


        }

        //when the hash key doesn't match, program returns null
        return -1;
    }

    public int SearchKey(int key, Integer[] HashTable1) {
      //to retrieve the position of integer keys in the integer hashtable

        // calculating the keys initial hash value or key
        int HashArrayIndex = key % arraySize;

        if (HashArrayIndex > arraySize){

            HashArrayIndex = HashArrayIndex % arraySize;
        }

        while (HashTable1[HashArrayIndex] != -1) {

            if (HashTable1[HashArrayIndex] == key) {

                //when we find the key matches succesfully, return it
                System.out.println("Key: " + key+ " is at index: " + HashArrayIndex);
                return 0;

            }

            //search and compare at the next index of the hash table
            HashArrayIndex++;


        }

        //when the hash key doesn't match, program returns null
        return -1;
    }

    public void displayerInt(Integer[] A){
        for (int i=0;i<A.length;i++){
            System.out.print(A[i]+ " ");
        }
        System.out.println();
    }

    public void displayerString(String[] B){
        for (int i=0;i<B.length;i++){
            System.out.print(B[i] + " ");
        }
        System.out.println();
    }

    public void showHashTableInteger(Integer[] A) { 
      //function to show the integer hashtable, displaying the position of each integer key and the cell they occupy in the hashtable
      
      System.out.println("Integer HashTable");

      int stepIncrease = 0;

      for (int c = 0; c < (arraySize/10); c++) {

          stepIncrease += 10;

          for (int i = 0; i < 71; i++)
              System.out.print("-"); //there's 71 columns in the hashtable

          System.out.println();

          for (int j = stepIncrease - 10; j < stepIncrease; j++) {

              System.out.format("| %3s " + " ", j);

          } //for the numbered heading on the hashtable signifying the hashvalues

          System.out.println("|"); //last vertical line at the row numbered row

          for (int i = 0; i < 71; i++)
              System.out.print("-"); //row separating hashvalues and keys

          System.out.println();

          for (int x = stepIncrease - 10; x < stepIncrease; x++) {

              if (A[x].equals("-1"))
                  System.out.print("|      "); //prints -1 for empty hash cells
              else
                  System.out.print(String.format("| %3s " + " ", A[x])); //prints the corresponding keys in the hash table cell

          }

          System.out.println("|");

          for (int i = 0; i < 71; i++)
              System.out.print("-"); //final closing row of dashes

          System.out.println();

      }
  }

    public void showHashTableString(String[] A) {
      //function to show the string hashtable, displaying the position of each string key and the cell they occupy in the hashtable

        System.out.println("String HashTable");

        int stepIncrease = 0;

        for (int c = 0; c < (arraySize/10); c++) {

            stepIncrease += 10;

            for (int i = 0; i < 71; i++)
                System.out.print("-"); //there's 71 columns in the hashtable

            System.out.println();

            for (int j = stepIncrease - 10; j < stepIncrease; j++) {

                System.out.format("| %3s " + " ", j);

            } //for the numbered heading on the hashtable signifying the hashvalues

            System.out.println("|"); //last vertical line at the row numbered row

            for (int i = 0; i < 71; i++)
                System.out.print("-"); //row separating hashvalues and keys

            System.out.println();

            for (int x = stepIncrease - 10; x < stepIncrease; x++) {

                if (A[x].equals("-1"))
                    System.out.print("|      "); //prints -1 for empty hash cells
                else
                    System.out.print(String.format("| %3s " + " ", A[x])); //prints the corresponding keys in the hash table cell

            }

            System.out.println("|");

            for (int i = 0; i < 71; i++)
                System.out.print("-"); //final closing row of dashes

            System.out.println();

        }
    }


}