package Main;

import java.util.HashMap;
import java.util.Map;

public class Basket {
	
	/* checkout(String) method calculates bill to be payed on checkout.
	 * Input is String involving items marked by characters from A..Z.
	 * Special offers are applied favoring customer and final amount to be payed is calculated on checkout */
	
    public Integer checkout(String items) {

    	Map<String,Integer> itemMap = new HashMap<String, Integer>();
    	
    	for(int index1=65; index1<90; index1++) {
    		itemMap.put(String.valueOf((char)index1), 0);
    	}
    	
    	for(char item:items.toCharArray()) {
    		switch(item){
    			case 'A':
	    		case 'B':
	    		case 'C':
	    		case 'D':
	    		case 'E':
	    		case 'F':
    			case 'G':
	    		case 'H':
	    		case 'I':
	    		case 'J':  
	    		case 'K':  
	    		case 'L':  
    			case 'M':
	    		case 'N':
	    		case 'O':
	    		case 'P':  
	    		case 'Q':  
	    		case 'R':  
	    		case 'S':  
    			case 'T':
	    		case 'U':
	    		case 'V':
	    		case 'W':  
	    		case 'X':  
	    		case 'Y':  
	    		case 'Z': itemMap.put(String.valueOf(item),itemMap.get(String.valueOf(item))+1); break;  		
	    		default: return -1;
    		}
    	}
    	
    	Integer totalCheckout = 0;
    	totalCheckout+=handleSpecialOffers(itemMap);
    	
    	return totalCheckout;
    }
    
    // handleSpecialOffers(Map) method calculates price of items in basket by applying special offers
    public int handleSpecialOffers(Map<String,Integer> itemMap) {
    	int totalCheckout = 0;
    	
    	int Es = itemMap.get("E");
    	int Bs = itemMap.get("B");
    	
    	if(Bs>Es/2)
    		Bs-=Es/2;
    	else Bs=0;
    	totalCheckout+=calculatePriceOfItem("B",Bs);
    	// Resetting amount of B, as it is already calculated and added to totalCheckout
    	itemMap.put("B",0);
    	
    	int Fs = itemMap.get("F");
    	Fs-=Fs/3;
    	totalCheckout+=calculatePriceOfItem("F",Fs);
    	itemMap.put("F",0);
    	
    	int Ns = itemMap.get("N");
    	int Ms = itemMap.get("M");

    	if(Ms>Ns/3)
    		Ms-=Ns/3;
    	else Ms=0;
    	totalCheckout+=calculatePriceOfItem("M",Ms);
    	itemMap.put("M",0);
    	
    	int Rs = itemMap.get("R");
    	int Qs = itemMap.get("Q");

    	if(Qs>Rs/3)
    		Qs-=Rs/3;
    	else Qs=0;
    	totalCheckout+=calculatePriceOfItem("Q",Qs);
    	itemMap.put("Q",0);
    	
    	int Us = itemMap.get("U");
    	Us-=Us/4;
    	totalCheckout+=calculatePriceOfItem("U",Us);
    	itemMap.put("U",0);
    	
    	for(String strItem:itemMap.keySet()) {
    		totalCheckout+=calculatePriceOfItem(strItem,itemMap.get(strItem));
    	}
    	return totalCheckout;
    }
    
    
    // Method to calculate price of items in basket by applying special prices
    public int calculatePriceOfItem(String item, int amount) {
    	switch(item) {
	    	case "A": return (amount/5)*200 + ((amount%5)/3)*130 + ((amount%5)%3)*50;
	    	case "B": return (amount/2)*45 + (amount%2)*30;
	    	case "C": return amount*20;
	    	case "D": return amount*15;
	    	case "E": return amount*40;
	    	case "F": return amount*10;
	    	case "G": return amount*20;
	    	case "H": return (amount/10)*80 + ((amount%10)/5)*45 + ((amount%10)%5)*10;
	    	case "I": return amount*35;
	    	case "J": return amount*60;
	    	case "K": return (amount/2)*150 + (amount%2)*80;
	    	case "L": return amount*90;
	    	case "M": return amount*15;
	    	case "N": return amount*40;
	    	case "O": return amount*10;
	    	case "P": return (amount/5)*200 + (amount%5)*50;
	    	case "Q": return (amount/3)*80 + (amount%3)*30;
	    	case "R": return amount*50;
	    	case "S": return amount*30;
	    	case "T": return amount*20;
	    	case "U": return amount*40;
	    	case "V": return (amount/3)*130 + ((amount%3)/2)*90 + ((amount%3)%2)*50;
	    	case "W": return amount*20;
	    	case "X": return amount*90;
	    	case "Y": return amount*10;
	    	case "Z": return amount*50;
	    	default: return 0;
    	}
    }
}
