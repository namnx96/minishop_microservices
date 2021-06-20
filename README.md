Project MiniShop with Microservice Architecture

## How to run?

### Build all modules:

`mvn clean install -DskipTests`

### Start services in docker:

`docker-compose up`

* discovery-service:
    * URL: http://localhost:9000/

* cart-service
* product-service   
* api-gateway    
    * URL: http://localhost:8080
    * All products: http://localhost:8080/api/v1/products
    * Find product by code: http://localhost:8080/api/v1/products/{productCode}
    * Add products to cart, example: 
    `curl -X POST \
  http://localhost:8080/api/v1/products/addCart \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: c53d095d-a8fb-24ff-68fe-021ab2637c62' \
  -d '[
  {
    "productId": 1,
    "quantity": 3
  },
  {
    "productId": 3,
    "quantity": 4
  },
  {
  	"productId": 6,
    "quantity": 45
  }
]'`  
    * Detail cart: http://localhost:8080/api/v1/carts
