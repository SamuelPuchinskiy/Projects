import heapq

from py.Node import Node

class Graph:

    def __init__(self):
        self.graph = {}
        self.heuristics = {}

    def add_node(self, u, edges):
        self.graph[u] = Node(u, edges)

    def add_node_heuristics(self, n, h):
        self.heuristics[n] = h

    #Copied from Homework 4
    def a_star_search(self, start, goals):
        if start in goals:
            return [0 , start]

        nodes = (self.graph[start]).edges
        queue = []
        self.initialize_queue(nodes, queue, start)

        while queue:
            top_node = heapq.heappop(queue)
            tail = top_node[2][0]
            if tail in goals:
                return [top_node[1],top_node[2][::-1]]
            self.update_queue(queue, tail, top_node)
        return None

    #Copied from Homework 4
    def initialize_queue(self, nodes, queue, start):
        for node, cost in nodes.items():
            priority = self.heuristics[node] + cost
            node_info = (priority, cost, [node, start])
            queue.append(node_info)
        heapq.heapify(queue)

    #Copied from Homework 4
    def update_queue(self, queue, tail, top_node):
        nodes = (self.graph[tail]).edges
        for node, cost in nodes.items():
            new_cost = cost + top_node[1]
            priority = self.heuristics[node] + new_cost
            heapq.heappush(queue, (priority, new_cost, [node] + top_node[2]))
