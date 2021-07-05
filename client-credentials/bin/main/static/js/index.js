(async () => {
  const employees = await fetch(
    "https://localhost:9443/employees"
  ).then((response) => response.json());

  console.log(employees);

  const table = document.querySelector("#js-employees > tbody");

  employees.forEach((employee) => {
    const row = document.createElement("tr");
    const tds = ["name", "role"].forEach((key) => {
      const td = document.createElement("td");
      td.textContent = employee[key];
      row.appendChild(td);
    });
    table.appendChild(row);
  });
})();
