-- USERS

create table users (
  id bigserial,
  username varchar(255),
  password varchar(255),
  enabled boolean not null,
  cart_id bigserial,
  primary key (id)
);

-- CART

create table carts (
  id bigserial,
  user_id bigserial,
  primary key (id)
);

-- LINK BETWEEN CART AND USER
alter table if exists carts
  add constraint carts_fk_user
  foreign key (user_id) references users;

alter table if exists users
  add constraint users_fk_cart
  foreign key (cart_id) references carts;

-- PRODUCTS

create table products (
  id bigserial,
  title varchar(255),
  price numeric,
  primary key (id)
);

-- PRODUCTS IN CART
create table cart_products (
  cart_id bigserial,
  product_id bigserial
);

alter table if exists cart_products
  add constraint cart_products_fk_product
  foreign key (product_id) references products;

alter table if exists cart_products
  add constraint cart_products_fk_cart
  foreign key (cart_id) references carts;

-- ORDERS

create table orders (
  id bigserial,
  address varchar(255),
  changed timestamp,
  created timestamp,
  status varchar(255),
  sum numeric(19, 2),
  user_id bigserial,
  primary key (id)
);

alter table if exists orders
  add constraint orders_fk_user
  foreign key (user_id) references users;

-- DETAILS OF ORDER

create table orders_details (
  id bigserial,
  order_id bigserial,
  product_id bigserial,
  amount numeric(19, 2),
  price numeric(19, 2),
  primary key (id)
);

alter table if exists orders_details
  add constraint orders_details_fk_order
  foreign key (order_id) references orders;

alter table if exists orders_details
  add constraint orders_details_fk_product
  foreign key (product_id) references products;