let nodeId = 0;

function createNode(type) {
    const node = document.createElement('div');
    node.className = 'operation-node';
    node.setAttribute('data-id', nodeId++);
    node.setAttribute('data-type', type);

    if (type === 'sensorId') {
        node.innerHTML = `<input placeholder="sensorId" class="sensor-input" />`;
    } else {
        node.innerHTML = `
            <label><strong>${type}</strong></label>
            <div class="inputs droppable-area"></div>
        `;
        addDropListener(node.querySelector('.inputs'));
    }

    return node;
}

function addDropListener(dropTarget) {
    dropTarget.addEventListener('dragover', ev => ev.preventDefault());
    dropTarget.addEventListener('drop', ev => {
        ev.preventDefault();
        const type = ev.dataTransfer.getData("text/plain");
        const node = createNode(type);
        dropTarget.appendChild(node);
        updateJson();
    });
}

document.querySelectorAll('.draggable').forEach(elem => {
    elem.addEventListener('dragstart', ev => {
        ev.dataTransfer.setData("text/plain", elem.textContent.trim());
    });
});

const root = document.getElementById('operation-root');
addDropListener(root);

function updateJson() {
    const first = root.firstElementChild;
    if (!first) return;
    const tree = buildJsonTree(first);
    document.getElementById('json-output').textContent = JSON.stringify(tree, null, 2);
    document.getElementById('json-input').value = JSON.stringify(tree);
}

function buildJsonTree(domNode) {
    const type = domNode.getAttribute('data-type');
    if (type === 'sensorId') {
        const input = domNode.querySelector('.sensor-input');
        return { sensorId: input.value };
    }

    const inputContainer = domNode.querySelector('.inputs');
    const children = [...inputContainer.children].filter(child => child.classList.contains('operation-node'));
    return {
        operation: type,
        inputs: children.map(buildJsonTree)
    };
}
