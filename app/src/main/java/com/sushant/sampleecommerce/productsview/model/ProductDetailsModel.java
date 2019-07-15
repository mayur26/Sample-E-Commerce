package com.sushant.sampleecommerce.productsview.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductDetailsModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Banner {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("link_type")
        @Expose
        private String linkType;
        @SerializedName("link_id")
        @Expose
        private String linkId;
        @SerializedName("link_title")
        @Expose
        private String linkTitle;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("website_image")
        @Expose
        private String websiteImage;

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

        public String getLinkType() {
            return linkType;
        }

        public void setLinkType(String linkType) {
            this.linkType = linkType;
        }

        public String getLinkId() {
            return linkId;
        }

        public void setLinkId(String linkId) {
            this.linkId = linkId;
        }

        public String getLinkTitle() {
            return linkTitle;
        }

        public void setLinkTitle(String linkTitle) {
            this.linkTitle = linkTitle;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getWebsiteImage() {
            return websiteImage;
        }

        public void setWebsiteImage(String websiteImage) {
            this.websiteImage = websiteImage;
        }

    }

    public class BestSeller {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("regular_price")
        @Expose
        private String regularPrice;
        @SerializedName("final_price")
        @Expose
        private String finalPrice;
        @SerializedName("currency_code")
        @Expose
        private String currencyCode;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("brand_name")
        @Expose
        private String brandName;
        @SerializedName("is_saleable")
        @Expose
        private Integer isSaleable;
        @SerializedName("item_in_cart")
        @Expose
        private Integer itemInCart;
        @SerializedName("item_in_wishlist")
        @Expose
        private Integer itemInWishlist;
        @SerializedName("type")
        @Expose
        private String type;

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

        public String getRegularPrice() {
            return regularPrice;
        }

        public void setRegularPrice(String regularPrice) {
            this.regularPrice = regularPrice;
        }

        public String getFinalPrice() {
            return finalPrice;
        }

        public void setFinalPrice(String finalPrice) {
            this.finalPrice = finalPrice;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public Integer getIsSaleable() {
            return isSaleable;
        }

        public void setIsSaleable(Integer isSaleable) {
            this.isSaleable = isSaleable;
        }

        public Integer getItemInCart() {
            return itemInCart;
        }

        public void setItemInCart(Integer itemInCart) {
            this.itemInCart = itemInCart;
        }

        public Integer getItemInWishlist() {
            return itemInWishlist;
        }

        public void setItemInWishlist(Integer itemInWishlist) {
            this.itemInWishlist = itemInWishlist;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }

    public class Data {

        @SerializedName("banners")
        @Expose
        private List<Banner> banners = null;
        /*@SerializedName("categories")
        @Expose
        private List<Object> categories = null;*/
        @SerializedName("featured")
        @Expose
        private List<CommonProduct> featured = null;
        @SerializedName("new_arrivals")
        @Expose
        private List<CommonProduct> newArrivals = null;
        @SerializedName("best_sellers")
        @Expose
        private List<CommonProduct> bestSellers = null;
        @SerializedName("popular_searches")
        @Expose
        private List<CommonProduct> popularSearches = null;
        @SerializedName("notify_text")
        @Expose
        private String notifyText;
        @SerializedName("support_phone")
        @Expose
        private String supportPhone;
        @SerializedName("support_email")
        @Expose
        private String supportEmail;
        @SerializedName("men_image")
        @Expose
        private String menImage;
        @SerializedName("kids_image")
        @Expose
        private String kidsImage;
        @SerializedName("website_men_image")
        @Expose
        private String websiteMenImage;
        @SerializedName("website_kids_image")
        @Expose
        private String websiteKidsImage;

        public List<Banner> getBanners() {
            return banners;
        }

        public void setBanners(List<Banner> banners) {
            this.banners = banners;
        }

        /*public List<Object> getCategories() {
            return categories;
        }

        public void setCategories(List<Object> categories) {
            this.categories = categories;
        }
*/
        public List<CommonProduct> getFeatured() {
            return featured;
        }

        public void setFeatured(List<CommonProduct> featured) {
            this.featured = featured;
        }

        public List<CommonProduct> getNewArrivals() {
            return newArrivals;
        }

        public void setNewArrivals(List<CommonProduct> newArrivals) {
            this.newArrivals = newArrivals;
        }

        public List<CommonProduct> getBestSellers() {
            return bestSellers;
        }

        public void setBestSellers(List<CommonProduct> bestSellers) {
            this.bestSellers = bestSellers;
        }

        public List<CommonProduct> getPopularSearches() {
            return popularSearches;
        }

        public void setPopularSearches(List<CommonProduct> popularSearches) {
            this.popularSearches = popularSearches;
        }

        public String getNotifyText() {
            return notifyText;
        }

        public void setNotifyText(String notifyText) {
            this.notifyText = notifyText;
        }

        public String getSupportPhone() {
            return supportPhone;
        }

        public void setSupportPhone(String supportPhone) {
            this.supportPhone = supportPhone;
        }

        public String getSupportEmail() {
            return supportEmail;
        }

        public void setSupportEmail(String supportEmail) {
            this.supportEmail = supportEmail;
        }

        public String getMenImage() {
            return menImage;
        }

        public void setMenImage(String menImage) {
            this.menImage = menImage;
        }

        public String getKidsImage() {
            return kidsImage;
        }

        public void setKidsImage(String kidsImage) {
            this.kidsImage = kidsImage;
        }

        public String getWebsiteMenImage() {
            return websiteMenImage;
        }

        public void setWebsiteMenImage(String websiteMenImage) {
            this.websiteMenImage = websiteMenImage;
        }

        public String getWebsiteKidsImage() {
            return websiteKidsImage;
        }

        public void setWebsiteKidsImage(String websiteKidsImage) {
            this.websiteKidsImage = websiteKidsImage;
        }

        public class CommonProduct {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("regular_price")
            @Expose
            private String regularPrice;
            @SerializedName("final_price")
            @Expose
            private String finalPrice;
            @SerializedName("currency_code")
            @Expose
            private String currencyCode;
            @SerializedName("image")
            @Expose
            private String image;
            @SerializedName("brand_name")
            @Expose
            private String brandName;
            @SerializedName("is_saleable")
            @Expose
            private Integer isSaleable;
            @SerializedName("item_in_cart")
            @Expose
            private Integer itemInCart;
            @SerializedName("item_in_wishlist")
            @Expose
            private Integer itemInWishlist;
            @SerializedName("type")
            @Expose
            private String type;

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

            public String getRegularPrice() {
                return regularPrice;
            }

            public void setRegularPrice(String regularPrice) {
                this.regularPrice = regularPrice;
            }

            public String getFinalPrice() {
                return finalPrice;
            }

            public void setFinalPrice(String finalPrice) {
                this.finalPrice = finalPrice;
            }

            public String getCurrencyCode() {
                return currencyCode;
            }

            public void setCurrencyCode(String currencyCode) {
                this.currencyCode = currencyCode;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public Integer getIsSaleable() {
                return isSaleable;
            }

            public void setIsSaleable(Integer isSaleable) {
                this.isSaleable = isSaleable;
            }

            public Integer getItemInCart() {
                return itemInCart;
            }

            public void setItemInCart(Integer itemInCart) {
                this.itemInCart = itemInCart;
            }

            public Integer getItemInWishlist() {
                return itemInWishlist;
            }

            public void setItemInWishlist(Integer itemInWishlist) {
                this.itemInWishlist = itemInWishlist;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

        }


    }

    public class NewArrival {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("regular_price")
        @Expose
        private String regularPrice;
        @SerializedName("final_price")
        @Expose
        private String finalPrice;
        @SerializedName("currency_code")
        @Expose
        private String currencyCode;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("brand_name")
        @Expose
        private String brandName;
        @SerializedName("is_saleable")
        @Expose
        private Integer isSaleable;
        @SerializedName("item_in_cart")
        @Expose
        private Integer itemInCart;
        @SerializedName("item_in_wishlist")
        @Expose
        private Integer itemInWishlist;
        @SerializedName("type")
        @Expose
        private String type;

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

        public String getRegularPrice() {
            return regularPrice;
        }

        public void setRegularPrice(String regularPrice) {
            this.regularPrice = regularPrice;
        }

        public String getFinalPrice() {
            return finalPrice;
        }

        public void setFinalPrice(String finalPrice) {
            this.finalPrice = finalPrice;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public Integer getIsSaleable() {
            return isSaleable;
        }

        public void setIsSaleable(Integer isSaleable) {
            this.isSaleable = isSaleable;
        }

        public Integer getItemInCart() {
            return itemInCart;
        }

        public void setItemInCart(Integer itemInCart) {
            this.itemInCart = itemInCart;
        }

        public Integer getItemInWishlist() {
            return itemInWishlist;
        }

        public void setItemInWishlist(Integer itemInWishlist) {
            this.itemInWishlist = itemInWishlist;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }

    public class PopularSearch {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("type_id")
        @Expose
        private String typeId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("product_total")
        @Expose
        private String productTotal;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProductTotal() {
            return productTotal;
        }

        public void setProductTotal(String productTotal) {
            this.productTotal = productTotal;
        }

    }
}



