public class Main {
    public static void main(String[] args) {

        Hashing h1 = new Hashing(40);

        //sample data inputs, but need to generate again
        String[] inputElementsString = {"Cool","Test","Hi","Sunday","Friday","Hi"};

        Integer[] inputElementsInteger = {100, 510, 170, 214, 268, 214, 214, 214 };


        h1.insertToHashTable(inputElementsString, h1.HashTableStringLinear);
        h1.insertToHashTable(inputElementsInteger, h1.HashTableIntegerLinear);
        //call function to display hash table and search for key
        h1.SearchKey(510, h1.HashTableIntegerLinear);
        h1.SearchKey("Cool", h1.HashTableStringLinear);

        //displaying linear probing insert
        System.out.println("Linear Probing");
        System.out.println();
        System.out.println("Integer HashTable");
        h1.displayerInt(h1.HashTableIntegerLinear);
        h1.showHashTableInteger(h1.HashTableIntegerLinear);
        System.out.println();
        System.out.println("String HashTable");
        h1.displayerString(h1.HashTableStringLinear);
        h1.showHashTableString(h1.HashTableStringLinear);
        System.out.println();


        //displaying double hashing insert
        h1.insertDoubleHashStr(inputElementsString, h1.HashTableStringDouble);
        h1.insertDoubleHashInt(inputElementsInteger, h1.HashTableIntegerDouble);

        //displaying integer hashtable 
        System.out.println();
        System.out.println("Integer HashTable");
        h1.displayerInt(h1.HashTableIntegerDouble);
        h1.showHashTableInteger(h1.HashTableIntegerDouble);
        System.out.println();
        //displaying String hashtable 
        System.out.println("String HashTable");
        h1.displayerString( h1.HashTableStringDouble);
        h1.showHashTableString(h1.HashTableStringDouble);
        System.out.println();


    }
}