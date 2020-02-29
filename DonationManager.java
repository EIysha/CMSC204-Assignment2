public class DonationManager implements DonationManagerInterface {
	private RecipientLine recipientLine = new RecipientLine();
	private VolunteerLine volunteerLine = new VolunteerLine();
	private Container container = new Container();
	private String message = "";
	
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		try {
			return container.loadContainer(dPackage);
		}

		catch(ContainerException e) {
			throw new ContainerException(e.getMessage());
		}
	}
	
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		try {
			
			return volunteerLine.addNewVolunteer(v);
		}
		catch(VolunteerException e) {
			
			throw new VolunteerException(e.getMessage());
		}
	}
	
	
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		try {
		
			return recipientLine.addNewRecipient(r);
		}
		catch(RecipientException e) {
			
			throw new RecipientException(e.getMessage());
		}
	}
	
	
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		try {
			
			 Volunteer v = volunteerLine.volunteerTurn();
			 volunteerLine.addNewVolunteer(v);
			
			 if(recipientLine.recipientLineEmpty()) {
			
			 	 throw new RecipientException("The Recipient Queue is Empty");
			 }
		
			 if(container.containerEmpty()) {
				
				 throw new ContainerException("The Container Stack is Empty");
			 }
			
			 Recipient r = recipientLine.recipientTurn();
			 DonationPackage c = container.removePackageFromContainer();
			 message = v.toString() + "delivered " + c.toString() + "to " + r.toString(); 
		}
		
		catch(VolunteerException v) {
			
			throw new VolunteerException(v.getMessage());
		}
		
		catch(ContainerException C) {
			
			throw new ContainerException(C.getMessage());
		}
		
		catch(RecipientException r) {
			
			throw new RecipientException(r.getMessage());
		}
		
		return 0;
	}


	@Override
	public DonationPackage[] managerArrayPackage() {
		return container.toArrayPackage();
	}


	@Override
	public Volunteer[] managerArrayVolunteer() {
		// TODO Auto-generated method stub
		return volunteerLine.toArrayVolunteer();
	}


	@Override
	public Recipient[] managerArrayRecipient() {
		// TODO Auto-generated method stub
		return recipientLine.toArrayRecipient();
	}

}