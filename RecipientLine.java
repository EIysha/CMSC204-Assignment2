public class RecipientLine implements RecipientLineInterface {
	
	private MyQueue<Object> recipient;
	
	
	public RecipientLine() {
		
		recipient = new MyQueue<Object>();
	}
	
	public RecipientLine(int size) {

		recipient = new MyQueue<Object>(size);
	}

	public boolean addNewRecipient(Recipient rc) throws RecipientException {
		
		if(recipient.isFull()) {
			
			throw new RecipientException("Recipient Queue is full");
		}
		
		recipient.enqueue(rc);
		
		return true;
	}

	public Recipient recipientTurn() throws RecipientException {
		
		if(recipient.isEmpty()) {
			
			throw new RecipientException("Recipient Queue is empty");
		}
		
		return (Recipient) recipient.dequeue();
	}

	public boolean recipientLineEmpty() {
		
		return recipient.isEmpty();
	}

	public Recipient[] toArrayRecipient() {
		
		String R = "";
		Object[] array = recipient.toArray();
		Recipient[] recipientCopy = new Recipient[array.length];
		for(int i=0; i < recipient.size(); i++) {
		
			R = ((Recipient) array[i]).getName();
			recipientCopy[i] = new Recipient(R);
		}
		
		return recipientCopy;
	}
}
