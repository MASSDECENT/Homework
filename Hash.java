/**
 *
 * @Sirawit_Tehcavanitch 5907101011 ;
 */

public class Hash {
    private String key;
    private String value;

    Hash(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue(String key) {
        
    	// use if to detected statements don't need
    	if(this.value == null)
             return "this index is null";
        else
        	return this.value;
    }

}
