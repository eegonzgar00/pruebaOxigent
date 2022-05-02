create table knowledgeTest_Candidate (
	uuid_ VARCHAR(75) null,
	candidateId LONG not null primary key,
	name VARCHAR(75) null,
	company VARCHAR(75) null,
	passed BOOLEAN,
	points INTEGER,
	testDate DATE null,
	location VARCHAR(75) null
);

create table knowledgeTest_Producto (
	uuid_ VARCHAR(75) null,
	productId LONG not null primary key,
	name VARCHAR(75) null,
	creationDate DATE null
);