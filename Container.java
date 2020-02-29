public class Container implements ContainerInterface {
	
	private MyStack<Object> container;
	
	public Container() {
		
		container = new MyStack<Object>();
	}
	
	public Container(int i) {
		
		container = new MyStack<Object>(i);
	}

	
	public DonationPackage removePackageFromContainer() throws ContainerException {
		
		if(container.isEmpty())
			throw new ContainerException("The Container is Empty");
		
		return (DonationPackage) container.pop();
	}
	
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		
		if(container.isFull())
			throw new ContainerException("The Container is Full");
		
		return container.push(dPackage);
	}

	
	public DonationPackage[] toArrayPackage() {
		
		double weight = 0;
		String description = "";
		Object[] containerStackArray = container.toArray();
		DonationPackage[] containerStackCopy = new DonationPackage[containerStackArray.length];
		for(int i = 0; i < container.size(); i++) {
			
			description = ((DonationPackage) containerStackArray[i]).getDescription();
			weight = ((DonationPackage) containerStackArray[i]).getWeight();
			containerStackCopy[i] = new DonationPackage(description, weight);
		}
		
		return containerStackCopy;
	}

	public boolean containerEmpty() {
		
		return container.isEmpty();
	}
}