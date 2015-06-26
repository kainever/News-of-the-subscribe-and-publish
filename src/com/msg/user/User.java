package com.msg.user;
// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * User entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("rawtypes")
public class User  implements java.io.Serializable {


    // Fields    

	private static final long serialVersionUID = 1L;
	
	private Integer id;
     private String name;
     private String email;
     private String password;
     private String imgSrc;
     private Timestamp lateOnline;
     private Integer notices;
     
     private Set friendId = new HashSet(0);
//     private Set usersForFriendId = new HashSet(0);
     
     private Set statuses = new HashSet(0);
     private Set comments = new HashSet(0);
     private Set notifications = new HashSet(0);


    // Constructors

    /** default constructor */
    public User() {
    }

	/** minimal constructor */
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public Timestamp getLateOnline() {
		return lateOnline;
	}

	public void setLateOnline(Timestamp lateOnline) {
		this.lateOnline = lateOnline;
	}

	public Integer getNotices() {
		return notices;
	}

	public void setNotices(Integer notices) {
		this.notices = notices;
	}

	public Set getFriendId() {
		return friendId;
	}

	public void setFriendId(Set friendId) {
		this.friendId = friendId;
	}

	public Set getStatuses() {
		return statuses;
	}

	public void setStatuses(Set statuses) {
		this.statuses = statuses;
	}

	public Set getComments() {
		return comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getNotifications() {
		return notifications;
	}

	public void setNotifications(Set notifications) {
		this.notifications = notifications;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

   

}