package comp.is.model.project.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import comp.is.model.admin.Employee;


/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Entity
@Table(name="EMPLOYEE")
public class EmployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	protected double accumflextime;
	protected double accumvacation;
	protected String firstname;
	protected int id;
	protected String lastname;
	protected Set<EmployeelabourchargerateEntity> labourChargeRates;
	protected Set<EmployeeroleEntity> roles;
	protected Set<EmployeeEntity> supervisors;
	protected Set<WorkpackageEntity> workPackages;
	protected double percentfulltime;
	//protected List<ProjectEntity> projects;
	protected Set<ProjectsummaryEntity> projectSummaries;
	protected Set<RatesheetEntity> rateSheets;
	protected Set<EmployeeEntity> timeSheetApprovers;
	protected Set<TimesheetEntity> timeSheets;

    public EmployeeEntity() {
    }


	public EmployeeEntity(Employee e) {
	    if(e == null){return;}
	    firstname = e.firstname;
	    id = e.id;
	    lastname = e.lastname;
    }


    @Column(precision=126)
	public double getAccumflextime() {
		return this.accumflextime;
	}

	@Column(precision=126)
	public double getAccumvacation() {
		return this.accumvacation;
	}


	@Column(length=64)
	public String getFirstname() {
		return this.firstname;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false, precision=16)
	public int getId() {
		return this.id;
	}


	@Column(length=64)
	public String getLastname() {
		return this.lastname;
	}

	//bi-directional many-to-one association to Employeelabourchargerate
	@OneToMany(mappedBy="employee", cascade={CascadeType.ALL})
	public Set<EmployeelabourchargerateEntity> getLabourChargeRates() {
		return this.labourChargeRates;
	}


	//bi-directional many-to-one association to Employeerole
	@OneToMany(mappedBy="employee")
	public Set<EmployeeroleEntity> getRoles() {
		return this.roles;
	}

	//uni-directional many-to-many association to Employee
	@ManyToMany
	@JoinTable(
		name="EMPLOYEESUPERVISOR"
		, joinColumns={
			@JoinColumn(name="ID", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="SUPERVISORID", nullable=false)
			}
		)
	public Set<EmployeeEntity> getSupervisors() {
		return this.supervisors;
	}


	//bi-directional many-to-many association to Workpackage
	@ManyToMany(mappedBy="employeesAssigned")
	public Set<WorkpackageEntity> getWorkPackages() {
		return this.workPackages;
	}

	@Column(precision=126)
	public double getPercentfulltime() {
		return this.percentfulltime;
	}


	//bi-directional many-to-one association to Projectsummary
	@OneToMany(mappedBy="projectManager")
	public Set<ProjectsummaryEntity> getProjectSummaries() {
		return this.projectSummaries;
	}

	//bi-directional many-to-one association to Ratesheet
	@OneToMany(mappedBy="projectManager")
	public Set<RatesheetEntity> getRateSheets() {
		return this.rateSheets;
	}


	//uni-directional many-to-many association to Employee
	@ManyToMany
	@JoinTable(
		name="TIMESHEETAPPROVER"
		, joinColumns={
			@JoinColumn(name="ID", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="TSAPPROVERID", nullable=false)
			}
		)
	public Set<EmployeeEntity> getTimeSheetApprovers() {
		return this.timeSheetApprovers;
	}

	//bi-directional many-to-one association to Timesheet
	@OneToMany(mappedBy="employee", fetch = FetchType.EAGER)
	public Set<TimesheetEntity> getTimeSheets() {
		return this.timeSheets;
	}
	

	public void setAccumflextime(double empaccumflextime) {
		this.accumflextime = empaccumflextime;
	}

	public void setAccumvacation(double empaccumvacation) {
		this.accumvacation = empaccumvacation;
	}
	

	public void setFirstname(String empfirstname) {
		this.firstname = empfirstname;
	}

	public void setId(int empid) {
		this.id = empid;
	}
	

//	//bi-directional many-to-many association to Project
//	@ManyToMany(mappedBy="projectEmployees")
//	public List<ProjectEntity> getProjects() {
//		return this.projects;
//	}
//
//	public void setProjects(List<ProjectEntity> projects) {
//		this.projects = projects;
//	}
//	

	public void setLastname(String emplastname) {
		this.lastname = emplastname;
	}

	public void setLabourChargeRates(Set<EmployeelabourchargerateEntity> employeeLabourChargeRates) {
		this.labourChargeRates = employeeLabourChargeRates;
	}
	

	public void setRoles(Set<EmployeeroleEntity> employeeRoles) {
		this.roles = employeeRoles;
	}

	public void setSupervisors(Set<EmployeeEntity> employeeSupervisors) {
		this.supervisors = employeeSupervisors;
	}	

	public void setWorkPackages(Set<WorkpackageEntity> employeesWorkPackages) {
		this.workPackages = employeesWorkPackages;
	}

	public void setPercentfulltime(double emppercentfulltime) {
		this.percentfulltime = emppercentfulltime;
	}
	

	public void setProjectSummaries(Set<ProjectsummaryEntity> projectSummaries) {
		this.projectSummaries = projectSummaries;
	}

	public void setRateSheets(Set<RatesheetEntity> rateSheets) {
		this.rateSheets = rateSheets;
	}
	

	public void setTimeSheetApprovers(Set<EmployeeEntity> timeSheetApprovers) {
		this.timeSheetApprovers = timeSheetApprovers;
	}

	public void setTimeSheets(Set<TimesheetEntity> timeSheets) {
		this.timeSheets = timeSheets;
	}
	
}