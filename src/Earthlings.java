import java.util.*;
/*
Had my dad help set up github using command lines so the Repo might look slightly differnet from normal
*/
public class Earthlings {
	Queue<String> apl = new LinkedList<String>();
	HashMap <String, String> abk = new HashMap <String, String>();
	TreeSet <String> arv = new TreeSet <String>();
	//adds applicants
	public void apply(String name, String adrs) {
		apl.add(name);
		abk.put(name, adrs);
	}
	//pulls up next applicant
	public String nextApp() {
		return apl.peek();
	}
	//gets address
	public String getAdrs(String name) {
		return abk.get(name);
	}
	//removes applicant from queue and adds if approved
	public void approve(boolean aprv) {
		String app = apl.remove();
		if(aprv) {
			arv.add(app);
		}
	}
	//gives the power to decide who lives and who dies to YOU
	public void display() {
		int size = apl.size();
		Scanner scan = new Scanner(System.in);
		while(size!=0) {
			System.out.println("---Next Applicant---");
			System.out.println("Name: "+this.nextApp());
			System.out.println("Address: "+this.getAdrs(this.nextApp()));
			System.out.println("Approval status: (Enter 'approved' or 'denied')");
			
			String stat = scan.next();
			if(stat.equals("approved"))
				this.approve(true);
			else if(stat.equals("denied"))
				this.approve(false);
			else
				System.out.println("Enter vaild status");
			size=apl.size();
			System.out.println();
		}
	}
	//lists those who will live
	public void survivor() {
		Iterator<String> it = arv.iterator();
		String nex;
		System.out.println("--Approved--");
		while(it.hasNext()) {
			nex=it.next();
			System.out.println("Name: "+nex);
			System.out.println("Address: "+this.getAdrs(nex));
			System.out.println();
		}		
	}
	//search for people and gives address
	public void search() {
		String name = "";
		Scanner scan = new Scanner(System.in);
		System.out.println("--Search--");
		System.out.println("Search name: (enter 'done' to exit)");
		name = scan.nextLine();
		while (!name.equals("done")){
			if(arv.contains(name)) {
				System.out.println("Name: "+name);
				System.out.println("Address: "+this.getAdrs(name));
			}
			else
				System.out.println("Name not found");
			System.out.println();
			System.out.println("Search name: (enter full name or 'done' to exit)");
			name = scan.next();
		}
	}
	
	//main method
	public static void main(String[] args) {
		Earthlings e = new Earthlings();
		e.apply("Joe Pederson","House");
		e.apply("Bob Dog","Dog House");
		e.apply("Christopher Cross","Sailing");
		e.apply("George Benson","Give Me the Night");
		e.apply("Steely Dan","Peg");
		//approval process
		e.display();
		//lists who is approved
		e.survivor();
		//search approved list
		e.search();
	}
	//hello
	//bob dog
}
