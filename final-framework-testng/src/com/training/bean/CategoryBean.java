package com.training.bean;

public class CategoryBean {
	private String CategoryName;
	private String Description;
	private String MetatagTitle;
	private String  MetatagDescription;
	
	public CategoryBean() {
	}

	public CategoryBean(String CategoryName, String Description, String MetatagTitle,String MetatagDescription) {
		super();
		this.CategoryName = CategoryName;
		this.Description = Description;
		this.MetatagTitle=MetatagTitle;
		this.MetatagDescription=MetatagDescription;
	}

	
	@Override
	public String toString() {
		return "CategoryBean [CategoryName=" + CategoryName + ", Description=" + Description + " , MetatagTitle=" + MetatagTitle + " , MetatagDescription=" + MetatagDescription + "]";
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMetatagTitle() {
		return MetatagTitle;
	}

	public void setMetatagTitle(String metatagTitle) {
		MetatagTitle = metatagTitle;
	}

	public String getMetatagDescription() {
		return MetatagDescription;
	}

	public void setMetatagDescription(String metatagDescription) {
		MetatagDescription = metatagDescription;
	}

}
