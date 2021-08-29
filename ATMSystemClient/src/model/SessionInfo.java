package model;

public class SessionInfo {
	
	   private int cardNumber;
	   
	   public SessionInfo(int cardNumber) {
	        this.cardNumber = cardNumber;
	    }
	   
	   public SessionInfo() {
	        this.cardNumber = 0;
	    }

	    public void setCardNumber(int cn) {
	        this.cardNumber = cn;
	    }
	  
	    public int getCardNumber() {
	        return cardNumber;
	    }

	    protected void destroySession() {
	        // this.cardNumber = null;
	        
	    }

		@Override
		public String toString() {
			return "SessionInfo [cardNumber=" + cardNumber + "]";
		}
	    
	    

}
