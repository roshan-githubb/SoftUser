package com.roshan.week6.ui.contacts

class Contacts
// private int imageID;
// private String delimgID;
//constructor
(name: String, address: String, gender: String, age: String) {
    //Getter and Setter
    var name: String
    var address: String
    var gender: String
    var age: String

    init {
        this.name = name
        this.address = address
        this.gender = gender
        this.age = age
        // this.imageID = imageID;
        // this.delimgID = delimgID;
    }

    @JvmName("getName1")
    fun getName(): String {
        return name
    }


    @JvmName("getAddress1")
    fun getAddress(): String? {
        return address
    }


    @JvmName("getGender1")
    fun getGender(): String? {
        return gender
    }

    @JvmName("getAge1")
    fun getAge(): String?{
        return age
    }

    // public int getImageID()
    // {
    // return imageID;
    // }
    //
    // public void setImageID(int imageID)
    // {
    // this.imageID = imageID;
    //
    // }
    //
    // public String getDelimgID()
    // {
    // return delimgID;
    // }
    // public void setDelimgID(String delimgID)
    // {
    // this.delimgID =delimgID;
    // }
}