public class VolunteerLine implements VolunteerLineInterface {
	
	private MyQueue<Object> volunteer;
	
	public VolunteerLine() {
		
		volunteer = new MyQueue<Object>();
	}
	
	public VolunteerLine(int v) {
		
		volunteer = new MyQueue<Object>(v);
	}
	
	
	
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {
		
		if(volunteer.isFull()) {
			
			throw new VolunteerException("Volunteer Queue is full");
		}
		
		volunteer.enqueue(v);
		
		return true;
	}

	
	public Volunteer volunteerTurn() throws VolunteerException {
		
		if(volunteer.isEmpty()) {
			
			throw new VolunteerException("Volunteer Queue is empty");
		}
		
		return (Volunteer) volunteer.dequeue();
	}

	
	public boolean volunteerLineEmpty() {
		
		return volunteer.isEmpty();
	}

	
	public Volunteer[] toArrayVolunteer() {
		
		String V = "";
		
		Object[] array = volunteer.toArray();
		
		Volunteer[] volunteerCopy = new Volunteer[array.length];
		
		for(int i = 0; i < volunteer.size(); i++) {
			
			V = ((Volunteer) array[i]).getName();
			
			volunteerCopy[i] = new Volunteer(V);
		}
		
		return volunteerCopy;
	}
}
