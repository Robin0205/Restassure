
public class gitandjenkins {
	
	
	/*--------------------GIT & GITHUB----------------------
	 * CI PROCESS
	 * ==========
	 * pre-requisites
	 * ---------------
	 * 1)Install git s/w
	 * 2)create an account with github and create new repository
	 *    Repo URL :  https://github.com/Robin0205/samplerepo(samplerepo is the repo name)
	 *------------------------------------------------------
	 *
	 *Working space loaction : C:\Users\Robin\eclipse-workspace\Restassure---go to this location and open command prompt
	 *
	 *1)git init---->create an empty local repository
	 *
	 *2)git config --global user.name "Yourname"
	 * git config --global user.mail "abc@gmail.com"
	 * 
	 * 3)git status 
	 * 
	 * 4)git add -A----> add all the  files & folders to staging area.
	 * git add filename.ext  //to add single file
	 * git add *.ext  //with the same extension all the files will be added
	 * git add foldername   //to add entire folder
	 *  git  commit -m "This is my first commit"
	 *-----------------------------------------------------------------------
	 *  
	 *  Push the code to remote repository
	 *  5) git remote add origin "git hub url" ------>to do connection of local with remote repository.
	 *  
	 *  6)git push -u origin master(master is the branch name )in real time they will provide branch name
	 *  we need to mention that name here   (to push code from local to repo).
	 *  
	 *
	 *---------------------------JENKINS---------------------------------------
	 *Continous Integration
	 *=======================
	 *
	 *1)Before log in to the jenkins first we need to run (java -jar jenkins.war) i command prompt
	 *2)login to the jenkins by username and password
	 * then select ---Global tool configuration------
	 * then give the java path,maven path,and git path along with bash from programm files and
	 *  mention project name ,also have to mention remote repo(URL)  save and apply then it will take all the
	 *  project code from Remote repository then click save and apply.
	 *  
	 *  3) click on project and select build now.
	 */

}
