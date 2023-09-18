INSERT INTO "RecipeMetaData"("id", "title", "titlePhoto", "totalRating", "difficulty", "duration", "calories", "createdAt", "updatedAt")
VALUES 
('recipe1', 'Delicious Pasta', 'someByteDataHere', 4.5, 'Medium', '30 minutes', 400, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('recipe2', 'Chocolate Cake', 'someByteDataHere', 4.8, 'Hard', '2 hours', 650, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO "RecipeStep"("id", "stepNumber", "instructionText", "instructionPhoto", "createdAt", "updatedAt", "recipeMetaDataId")
VALUES 
('step1', 1, 'Boil the pasta', 'instructionPhotoDataHere', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'recipe1'),
('step2', 2, 'Add the sauce', 'instructionPhotoDataHere', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'recipe1'),
('step3', 1, 'Mix cocoa and flour', 'instructionPhotoDataHere', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'recipe2'),
('step4', 2, 'Add eggs and sugar', 'instructionPhotoDataHere', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'recipe2');

INSERT INTO "Category"("id", "name", "parentCategoryId")
VALUES 
('cat1', 'Main Course', NULL),
('cat2', 'Desserts', NULL),
('cat3', 'Italian', 'cat1');

INSERT INTO "Category2Recipe"("recipeMetaDataId", "categoryId")
VALUES 
('recipe1', 'cat1'),
('recipe1', 'cat3'),
('recipe2', 'cat2');

INSERT INTO "Ingredient"("id", "name", "defaultUnit", "link")
VALUES 
('ing1', 'Pasta', 'grams', 'http://linktopasta.com'),
('ing2', 'Tomato Sauce', 'ml', 'http://linktotomatosauce.com'),
('ing3', 'Cocoa', 'grams', 'http://linktococoa.com');

INSERT INTO "Ingredient2Recipe"("recipeMetaDataId", "ingredientId", "quantity", "packagingUnit", "portion")
VALUES 
('recipe1', 'ing1', 200, 'grams', 2),
('recipe1', 'ing2', 100, 'ml', 2),
('recipe2', 'ing3', 150, 'grams', 8);

INSERT INTO "User"("id", "email", "createdAt", "updatedAt")
VALUES
('user1', 'john.doe@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('user2', 'jane.doe@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO "Rating"("comment", "rating", "createdAt", "updatedAt", "recipeMetaDataId", "userId")
VALUES
('Delicious!', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'recipe1', 'user1'),
('Too sweet for me.', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'recipe2', 'user2');

INSERT INTO "Favorite"("notes", "createdAt", "updatedAt", "recipeMetaDataId", "userId")
VALUES
('Love this recipe!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'recipe1', 'user1');

INSERT INTO "GroceryList"("id", "name", "status", "createdAt", "updatedAt", "userId")
VALUES
('grocery1', 'Weekend Shopping', 'Pending', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'user1');

INSERT INTO "GroceryListItem"("id", "name", "status", "createdAt", "updatedAt", "userId", "groceryListId")
VALUES
('item1', 'Milk', 'Pending', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'user1', 'grocery1'),
('item2', 'Bread', 'Bought', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'user1', 'grocery1');
