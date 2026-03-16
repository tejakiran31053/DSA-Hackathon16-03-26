package team_project;

class PassengerNode {  // This is linked list node
	
    String name;
    PassengerNode next;
    
    PassengerNode(String name) {
        this.name = name;
        this.next = null;
    }
}