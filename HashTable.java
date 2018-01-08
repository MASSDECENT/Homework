
import java.util.Scanner;
/**
 *
 * @Sirawit_Tehcavanitch 5907101011 ;
 */
public class HashTable {
    // number of indexes in hash table
    private final static int Hashtable_size = 1200;
    // initialise array of HashEntry (table)
    Hash[] Hashtable;
    // constructor, create array, assign all values to null
    HashTable() {
        // create array of HashEntry, predefined size
    	Hashtable = new Hash[Hashtable_size];
    }

    // from key, find the correct index, load the HashEntry object and return the value
    public String getWord(String key) {
    	  key=key.toLowerCase();
        if(CheckKeyIndex(key)==true)
        	return  "|| Word Not Found || ";
        else{
        	int index = this.getKeyIndex(key);
            while(Hashtable[index].equals(key)==true){ //repeat doing it [(position = key) = true]
    	        index++;
    }
        return Hashtable[index].getValue(key); // return key = word 
        }
    }

    // creates a new HashEntry object, inserts that into the table array at the correct index
    // determined by getKeyIndex(key)
    public void AddWord(String key, String value) {
        key=key.toLowerCase(); // Form A to a
        	int index = this.getKeyIndex(key); //Form String to Hash number
        while(Hashtable[index]!=null){ // Loop repeat if index of array != null 
        	index++;					// index = position in array
        }								// position +1
        Hashtable[index] = new Hash(key, value); //create object to contain word and meaning
    }
    // ** PRIVATE FUNCTIONS ** //
    // get index from key
    private Integer getKeyIndex(String key) {
    	//from https://stackoverflow.com/a/2624210
        int Hashing = 7;
        for (int i = 0; i < key.length(); i++) {
            Hashing = (Hashing*31 + key.charAt(i))%1000;
        }
        return Hashing;
    }
    public boolean CheckKeyIndex(String key){
    	  key=key.toLowerCase();							
    	int index = this.getKeyIndex(key);
    	return Hashtable[index]==null;// found = false // not found = true //
    }
    public void EditWord(String key,String value){
    	  key=key.toLowerCase();
    	if(CheckKeyIndex(key)==true) 
    		 System.out.println("Your word '"+key+"' Not Found"); // don't do something
    	else{
            int index = this.getKeyIndex(key);						// do some thing
                while(Hashtable[index].getKey().equals(key)!=true){
                    index++;
                }
                Hashtable[index] = new Hash(key, value);
    		  System.out.println("Edit complete!");
    	}
    }
    public void DeleteWord(String key){
    	 key=key.toLowerCase();
    	 int index = this.getKeyIndex(key);
    	 Hashtable[index] = new Hash(null,"'"+key+"' Not Found");
    	 System.out.println("Your word "+key+" Delete complete!");
    }
    public void Display(){
        Scanner Input = new Scanner(System.in);
        	System.out.println("===============|| Word Menu ||===============");
        	System.out.println("1. Search ¤é¹ËÒ");
        	System.out.println("2. Add word à¾èÔèÁÈÑ¾·ì");
        	System.out.println("3. Delete word Åº¤ÓÈÑ¾·ì ");
        	System.out.println("4. Exit Program ÍÍ¡¨Ò¡â»Ãá¡ÃÁ");
        	System.out.println("============================");
        System.out.print("Enter choice àÅ×Í¡àÁ¹Ù·ÕèµéÍ§¡ÒÃ : ");
        //choice code//
         int choice = Input.nextInt();
                    switch(choice){
                    
                        case 1 :System.out.print("Enter word ¡ÃØ³ÒãÊè¤ÓÈÑ¾·ì·ÕèµéÍ§¡ÒÃ¤é¹¿Ò : ");
                                String Search = Input.next() ;
                                System.out.println("Word Found ¤Óá»Å : "+ getWord(Search) );
                                Display1(Search); 
                                break;
                                
                        case 2 :System.out.print("Add word à¾èÔèÁÈÑ¾·ì : ");
                                String Addword = Input.next();
                                System.out.print("Add meaning à¾èÔèÁ¤Óá»ÅÈÑ¾·ì : ");
                                String Addmeaning = Input.next();
                                AddWord(Addword, Addmeaning);
                                Display();   
                                break;
                        
                        case 3 :System.out.print("Enter word for delete ãÊè¤ÓÈÑ¾·ì·ÕèµéÍ§¡ÒÃÅº : ");
                                String Delete = Input.next() ;
                                DeleteWord(Delete);
                                Display();
                                break;

                        case 4 :System.out.print(" --------------End Program-------------- ");    
                        		break;
                        		
                        default :System.out.print("Enter number 1/2/3/4 only!");
                    }
    }
    public void Display1(String key){
         Scanner Input = new Scanner(System.in);
            System.out.println("===============|| Main Menu ||===============");
            System.out.println("1. Next word ¤ÓÈÑ¾·ìµèÍä»");
            System.out.println("2. Previous word ¤ÓÈÑ¾·ì¡èÍ¹Ë¹éÒ ");
            System.out.println("3. Edit word á¡éä¢¤ÓÈÑ¾·ì");
            System.out.println("4. Exit to Main Menu ÍÍ¡ä»·ÕèË¹éÒáÁ¹ÙËÅÑ¡");
            System.out.println("====================================");
            System.out.print("Enter choice àÅ×Í¡àÁ¹Ù·ÕèµéÍ§¡ÒÃ : ");
          //choice code//
            int choice = Input.nextInt();
            switch(choice)
            {
                case 1 :
                    key = NextPrevious(key,0);
                    	System.out.println("Next word is '"+key+"'");
                    	System.out.println("¤ÓÈÑ¾·ìµèÍä»'"+key+"'");
                    Display1(key);                      
                    break;
                case 2 :
                    key = NextPrevious(key,1);
                    	System.out.println("Previous word is '"+key+"'");
                    	System.out.println("¤ÓÈÑ¾·ì¡èÍ¹Ë¹éÒ'"+key+"'");
                    Display1(key);                       
                    break;
                case 3 : 
                    System.out.print("Edit word á¡éä¢¤ÓÈÑ¾·ì  : ");
                    	String EditWord = Input.next() ;
                    System.out.print("Edit meaning á¡éä¢¤Óá»Å : ");
                    	String EditMeaning = Input.next() ;
                    EditWord(EditWord,EditMeaning);
                    Display(); 
                    break;
                case 4 :
                	Display(); 
                    break;
                default :System.out.print("No choice Match");
                	Display(); 
            }
    }
    public String NextPrevious(String key,int list){
    	
    	key= key.toLowerCase();
        int index = getKeyIndex(key);
        
        if(list==0){
            index++;
             while(Hashtable[index]==null){
            	 index++;
             }
        }
        else{ index--;
                 while(Hashtable[index]==null){
                	 index--;
                 }
        }
            return  Hashtable[index].getKey();
    }
}
