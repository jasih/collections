package com.cooksys.ftd.assignments.collections.model;

import com.cooksys.ftd.assignments.collections.util.MissingImplementationException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * TODO: Implement this class
 *  <br><br>
 *  A worker is a type of employee that cannot be a superior to another employee.
 *  <br>
 *  A worker should have a name, and, optionally, a manager superior to them.
 */
public class Worker implements Employee {

    // TODO: Does this class need private fields? If so, add them here
	
	private String name;
	private Manager manager;

    /**
     * TODO: Implement this constructor.
     *
     * @param name the name of the worker to be created
     */
    public Worker(String name) {
        this.name = name;
    }

    /**
     *  TODO: Implement this constructor.
     *
     * @param name the name of the worker to be created
     * @param manager the direct manager of the worker to be created
     */
    public Worker(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
    }

    /**
     * TODO: Implement this getter.
     *
     * @return the name of the worker
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * TODO: Implement this getter.
     *
     * @return {@code true} if this worker has a manager, or {@code false} otherwise
     */
    @Override
    public boolean hasManager() {
        if (getManager() == null) {								// check if the manager has a manager, if not return false
        	return false;
        } else if (getManager() == manager){					// else return true
        	return true;
        }
        
        return false;											// return false otherwise
    }

    /**
     * TODO: Implement this getter.
     *
     * @return the manager of this worker, or null if it has none
     */
    @Override
    public Manager getManager() {
        if (manager == null) {
        	return null;
        }
        
        return manager;
    }

    /**
     * TODO: Implement this method.
     *  <br><br>
     *  Retrieves the worker's chain of command as a {@code List<Manager>}, starting with their direct {@code Manager},
     *  followed by that {@code Manager}'s {@code Manager}, and so on, until the top of the hierarchy is reached.
     *  <br><br>
     *  The returned list should never be or contain {@code null}.
     *  <br><br>
     *  If the worker does not have a {@code Manager}, an empty
     *  {@code List<Manager>} should be returned.
     *
     * @return a {@code List<Manager>} that represents the worker's chain of command,
     */
    
    // Hint: if you're using hashSet or hashMap you need to implement hashcode() and .equals()
    // Also, you can generate them using eclipse (Source -> generate hashcode() and equals()), BUT only do it AFTER you have added fields!!!
    // 
    
    // Hint: What this wants you to do is add all the Managers in a chain to a list of managers
    // For example, each manager object should keep track of its manager object
    // The manager object could be null, if it's null then that means that object has no manager
    // Look at the first sentence in the TODO - we know the top of the hierarchy is reached when the manager that you're currently looking at does not have a manager
    // And we know when a manager has no manager, its value is null
    
    // Works the same with worker (look at picture for reference or go to 11:43 in the video of the assignment)
    // Need a while loop or for loop, either one works
    // Need a variable that represents the current manager you have, and that current manager will change as you go through the loop until it eventually is null
    
    // Manager class will essentially be the same as Worker class, except in the Worker class, inside of them a worker can have a manager, but cannot have other workers in them
    
    @Override
    public List<Manager> getChainOfCommand() {
    	
    	List<Manager> workerCommandChain = new ArrayList<>();					// create a new list to store the chain of command for managers
    	
    	for (Manager m = manager; m != null; m = m.getManager()) {				// for each manager m, while m is not null, get the manager m
    		workerCommandChain.add(m);											// then add each manager to the list
    	}		
    	
    	return workerCommandChain;												// return the list
    }

	@Override
	public int hashCode() {
		return Objects.hash(manager, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(manager, other.manager) && Objects.equals(name, other.name);
	}

	
    

    // TODO: Does this class need custom .equals() and .hashcode() methods? If so, implement them here.

    // TODO [OPTIONAL]: Consider adding a custom .toString() method here if you want to debug your code with System.out.println() statements
}
