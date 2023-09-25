package in.mindcraft;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
private List<Product> list=new ArrayList<>();

public MyController() {
	list.add(new Product(101,"marker",50));
	list.add(new Product(102,"water bottle",70));
	list.add(new Product(103,"bag",250));
	
}


@RequestMapping(value="products",method=RequestMethod.GET)
public List<Product> getProducts(){
	System.out.println("get all products...");
	return list;
}

@RequestMapping(value="products/{id}",method=RequestMethod.GET)
public Product getProduct(@PathVariable int id) {
	for(Product p:list)
	{
		if(p.getPid()==id)
			return p;
	}
	return null;
}


@RequestMapping(value="products",method=RequestMethod.POST)
public List<Product> addProduct(@RequestBody Product p){
	list.add(p);
	return list;
}

@RequestMapping(value="products/{id}",method=RequestMethod.PUT)
public Product updateProduct(@PathVariable int id,@RequestBody Product up){
	for (Product p:list) {
       
        if (p.getPid() == id) {
            // Update the product's properties
            p.setMake(up.getMake());
            p.setCost(up.getCost());
            // You can update other properties similarly
            return p;
        }
        
    }
	
    return null;
}


@RequestMapping(value="products/{id}",method=RequestMethod.DELETE)
public List<Product> removeProduct(@PathVariable int id){
	Product indexToDelete = null;
    for (Product p: list) {
        if (p.getPid() == id) {
            indexToDelete = p;
            break;
        }
    }
    
    if (indexToDelete != null) {
        list.remove(indexToDelete);
        
    } 
    return list;
	
}
	
}

